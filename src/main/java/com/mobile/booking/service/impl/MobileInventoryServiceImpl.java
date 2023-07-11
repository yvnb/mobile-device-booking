package com.mobile.booking.service.impl;

import org.springframework.stereotype.Service;

import com.mobile.booking.dto.MobileBookingDTO;
import com.mobile.booking.exceptions.MobileInventoryOutOfStockException;
import com.mobile.booking.exceptions.ResourceNotFoundException;
import com.mobile.booking.model.MobileInventory;
import com.mobile.booking.repository.MobileInventoryRepository;
import com.mobile.booking.service.MobileInventoryService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class MobileInventoryServiceImpl implements MobileInventoryService {
	
	private MobileInventoryRepository mobileInventoryRepository;
	
	@Override
	public void depleteInventory(MobileBookingDTO mobileBookingDTO) {
		
		MobileInventory mobileInventory = mobileInventoryRepository.findById(mobileBookingDTO.getDeviceId())
				.orElseThrow(() -> new ResourceNotFoundException("Mobile Inventory not found"));
		
		// fetch the quantity for the mobile id from database
		int availableStock = mobileInventory.getQuantity();
		
		if (mobileBookingDTO.getQuantity() > availableStock) {
			
			throw new MobileInventoryOutOfStockException("Mobile Inventory not sufficient. Please try again");
		}
		
		//update the quantity of the mobile device
		mobileInventory.setQuantity(availableStock - mobileBookingDTO.getQuantity());
		
		mobileInventoryRepository.save(mobileInventory);
	}
	
	@Override
	public void replenishInventory(MobileBookingDTO mobileBookingDTO) {
		
		MobileInventory mobileInventory = mobileInventoryRepository.findById(mobileBookingDTO.getDeviceId())
				.orElseThrow(() -> new ResourceNotFoundException("Mobile Inventory not found"));
		
		// fetch the quantity for the mobile id from database
		int availableStock = mobileInventory.getQuantity();
		
		//update the quantity of the mobile device
		mobileInventory.setQuantity(availableStock + mobileBookingDTO.getQuantity());
		
		mobileInventoryRepository.save(mobileInventory);
	}	

}
