package com.hexa.travelbooking.bookingprocess;

import com.hexa.travelbooking.domain.TravelTicket;

public interface BookingSystem {

    public void setTravelTicket(TravelTicket travelTicket);
    public void requestBooking();
    public boolean getStatus();
    public boolean cancle();

}
