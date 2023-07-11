package com.mobile.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MobileInventoryDTO {

    private Long mobileId;
    private int quantity;
    private int status;
    
}
