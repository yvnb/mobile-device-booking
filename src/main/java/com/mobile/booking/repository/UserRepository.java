package com.mobile.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile.booking.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
