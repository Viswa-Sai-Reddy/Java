package com.hexa.travelbooking.bookingprocess;

import com.hexa.travelbooking.domain.TravelTicket;

public class EnjoyableTouringSystem implements BookingSystem{

    @Override
    public void setTravelTicket(TravelTicket travelTicket) {
        System.out.println("Enjoyable Touring had successfully booked "+ travelTicket);
    }

    @Override
    public void requestBooking() {
        System.out.println("Enjoyable Touring had successfully requested for booking ");
    }

    @Override
    public boolean getStatus() {
        System.out.println("Enjoyable Touring will provide Status");
        return false;
    }

    @Override
    public boolean cancle() {
        return false;
    }
}
