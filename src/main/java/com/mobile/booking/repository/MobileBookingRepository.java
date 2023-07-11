package com.mobile.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.booking.model.MobileBooking;

@Repository
public interface MobileBookingRepository extends JpaRepository<MobileBooking, Long> {

}
