package com.mobile.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.booking.model.MobileDevice;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice, Long> {

}
