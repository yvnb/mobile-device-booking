package com.mobile.booking.service;

import com.mobile.booking.dto.MobileBookingDTO;

public interface MobileInventoryService {

	void depleteInventory(MobileBookingDTO mobileBookingDTO);

	void replenishInventory(MobileBookingDTO mobileBookingDTO);
	
}
