package com.hexa.travelbooking.domain;

import com.hexa.travelbooking.Exception.InvalidTravelDurationException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class PlainTicket extends TravelTicket implements Comparable<TravelTicket>{

    private TravelClass travelClass;
    private Integer seatNumber;
    private Integer stopovers;

    public PlainTicket() {
        super();
    }

    public PlainTicket(Long bookingRef, String origin, String destination, BigDecimal price, LocalDateTime departureTime, LocalDateTime arrivalTime, TravelClass travelClass, Integer seatNumber, Integer stopovers) throws InvalidTravelDurationException {
        super(bookingRef, origin, destination, price, departureTime, arrivalTime);
        this.travelClass = travelClass;
        this.seatNumber = seatNumber;
        this.stopovers = stopovers;
    }

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getStopovers() {
        return stopovers;
    }

    public void setStopovers(Integer stopovers) {
        this.stopovers = stopovers;
    }

    @Override
    public String toString() {
        return "PlainTicket{" +
                "travelClass=" + travelClass +
                ", seatNumber=" + seatNumber +
                ", stopovers=" + stopovers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlainTicket that = (PlainTicket) o;
        return Objects.equals(travelClass, that.travelClass) && Objects.equals(seatNumber, that.seatNumber) && Objects.equals(stopovers, that.stopovers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), travelClass, seatNumber, stopovers);
    }

    public void upgrade() {
        System.out.println("You have been upgraded");
    }
    public void addStopOver() {
        stopovers++;
        System.out.println("You have "+stopovers);
    }
}
