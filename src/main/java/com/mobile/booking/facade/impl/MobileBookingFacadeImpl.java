package com.mobile.booking.facade.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobile.booking.dto.MobileBookingDTO;
import com.mobile.booking.facade.MobileBookingFacade;
import com.mobile.booking.service.MobileBookingService;
import com.mobile.booking.service.MobileInventoryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class MobileBookingFacadeImpl implements MobileBookingFacade {

    private MobileBookingService mobileBookingService;
    
    private MobileInventoryService mobileInventoryService;

	@Override
	@Transactional
	public MobileBookingDTO createBooking(MobileBookingDTO mobileBookingDTO) {
		
		//check for the inventory and deplete the inventory as per reservation
		mobileInventoryService.depleteInventory(mobileBookingDTO);
	
		//create booking if the inventory is updated successfully
		mobileBookingDTO = mobileBookingService.createBooking(mobileBookingDTO);
		
		return mobileBookingDTO;

	}

	@Override
	@Transactional
	public MobileBookingDTO createReturn(Long mobileBookingId) {
		
		MobileBookingDTO mobileBookingDTO = mobileBookingService.getBooking(mobileBookingId);
		
		// replenish the inventory as per return and booking id
		mobileInventoryService.replenishInventory(mobileBookingDTO);
		
		//create return after the inventory is updated successfully
		mobileBookingService.createReturn(mobileBookingDTO);
		
		return mobileBookingDTO;
	}

}
