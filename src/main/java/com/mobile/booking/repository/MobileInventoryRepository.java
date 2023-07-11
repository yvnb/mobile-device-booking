package com.mobile.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.booking.model.MobileInventory;

@Repository
public interface MobileInventoryRepository extends JpaRepository<MobileInventory, Long> {

}
