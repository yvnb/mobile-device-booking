package com.mobile.booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.booking.dto.MobileBookingDTO;
import com.mobile.booking.facade.MobileBookingFacade;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/mobile/")
@AllArgsConstructor
public class MobileBookingController {
	
	private MobileBookingFacade mobileBookingFacade;

	@PostMapping("/booking")
	public MobileBookingDTO createBooking(@Valid @RequestBody MobileBookingDTO mobileBookingDTO) {
		
		return mobileBookingFacade.createBooking(mobileBookingDTO);
		
	}

	@PostMapping("/booking/{bookingId}/return")
	public MobileBookingDTO createReturn(@PathVariable Long bookingId) {
		
		return mobileBookingFacade.createReturn(bookingId);
		
	}
	
}
