package com.mobile.booking.model;

public enum MobileBookingStatus {

    BOOKED(1, "Booked"),
    RETURNED(2, "Returned");

    private final int statusCode;
    private final String statusText;

    MobileBookingStatus(int statusCode, String statusText) {
        this.statusCode = statusCode;
        this.statusText = statusText;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusText() {
        return statusText;
    }
	
}
