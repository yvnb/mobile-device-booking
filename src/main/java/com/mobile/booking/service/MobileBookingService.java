package com.mobile.booking.service;

import com.mobile.booking.dto.MobileBookingDTO;

public interface MobileBookingService {

	public MobileBookingDTO createBooking(MobileBookingDTO mobileBookingDTO);
	
	public MobileBookingDTO createReturn(MobileBookingDTO mobileBookingDTO);

	public MobileBookingDTO getBooking(Long mobileBookingId);
}
