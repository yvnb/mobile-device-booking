package com.mobile.booking.facade;

import com.mobile.booking.dto.MobileBookingDTO;

public interface MobileBookingFacade {

	MobileBookingDTO createBooking(MobileBookingDTO mobileBookingDTO);
	
	MobileBookingDTO createReturn(Long mobileBookingId);
}
