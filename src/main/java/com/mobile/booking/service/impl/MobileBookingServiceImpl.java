package com.mobile.booking.service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.mobile.booking.dto.MobileBookingDTO;
import com.mobile.booking.exceptions.ResourceNotFoundException;
import com.mobile.booking.model.MobileBooking;
import com.mobile.booking.model.MobileBookingStatus;
import com.mobile.booking.repository.MobileBookingRepository;
import com.mobile.booking.service.MobileBookingService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class MobileBookingServiceImpl implements MobileBookingService {

	private ModelMapper modelMapper;
	
	private MobileBookingRepository mobileBookingRepository;
	
	@Override
	public MobileBookingDTO createBooking(MobileBookingDTO mobileBookingDTO) {
		
		Date bookingDate = new Date();
		mobileBookingDTO.setBookingDate(bookingDate);
		mobileBookingDTO.setStatus(MobileBookingStatus.BOOKED.getStatusCode());
		MobileBooking mobileBooking = modelMapper.map(mobileBookingDTO, MobileBooking.class);		
		MobileBooking newBooking = mobileBookingRepository.save(mobileBooking);
		modelMapper.map(newBooking, mobileBookingDTO);
		return mobileBookingDTO;
	}

	@Override
	public MobileBookingDTO createReturn(MobileBookingDTO mobileBookingDTO) {
				
		MobileBooking mobileReturn = new MobileBooking();
		
		mobileReturn.setDeviceId(mobileBookingDTO.getDeviceId());
		mobileReturn.setUserId(mobileBookingDTO.getUserId());
		mobileReturn.setQuantity(mobileBookingDTO.getQuantity());
		mobileReturn.setBookingDate(new Date());
		mobileReturn.setStatus(MobileBookingStatus.RETURNED.getStatusCode());
		
		MobileBooking newReturn = mobileBookingRepository.save(mobileReturn);
		modelMapper.map(newReturn, mobileBookingDTO);
		return mobileBookingDTO;
	}

	@Override
	public MobileBookingDTO getBooking(Long mobileBookingId) {
		
		MobileBooking mobileBooking = mobileBookingRepository.findById(mobileBookingId)
				.orElseThrow(() -> new ResourceNotFoundException("Mobile Booking not found"));
		
		MobileBookingDTO mobileBookingDTO = modelMapper.map(mobileBooking, MobileBookingDTO.class);
		
		return mobileBookingDTO;
	}

}
