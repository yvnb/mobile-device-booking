package com.mobile.booking.exceptions;

public class MobileInventoryOutOfStockException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public MobileInventoryOutOfStockException(String message) {
        super(message);
    }
    
}
