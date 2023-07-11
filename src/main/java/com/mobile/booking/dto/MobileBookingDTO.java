package com.mobile.booking.dto;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileBookingDTO {

    private Long id;
    @NotNull(message = "User ID must not be null")
    private Long userId;
    @NotNull(message = "Device ID must not be null")
    private Long deviceId;
    private Date bookingDate;
    @NotNull(message = "Quantity must not be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;
    private int status;
    
}
