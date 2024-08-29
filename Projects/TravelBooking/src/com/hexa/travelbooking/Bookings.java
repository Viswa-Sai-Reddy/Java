package com.hexa.travelbooking;

import com.hexa.travelbooking.Exception.InvalidTravelDurationException;
import com.hexa.travelbooking.domain.BusTicket;
import com.hexa.travelbooking.domain.PlainTicket;
import com.hexa.travelbooking.domain.TrainTicket;
import com.hexa.travelbooking.domain.TravelClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Bookings {
    private static int ticketType;

    public static void main(String[] args) throws InvalidTravelDurationException {
        Scanner s = new Scanner(System.in);
        int ticketType = 0;
        while (!(ticketType > 0 && ticketType < 4)) {
            System.out.println("Please choose Ticket Type:\n 1:Bus Ticket\n 2:Train Ticket\n 3:Plain Ticket");
            ticketType = s.nextInt();
        }

        //TravelTicket Inputs
        System.out.println("Enter the booking Ref");
        Long bookingref = s.nextLong();
        s.nextLine();

        System.out.println("Enter the origin");
        String origin = s.nextLine();
        //s.nextLine();

        System.out.println("Enter the destination");
        String destination = s.nextLine();
        //s.nextLine();

        System.out.println("Enter the price");
        BigDecimal price = s.nextBigDecimal();
        s.nextLine();

        System.out.println("Enter Departure Time");
        String dtime = s.nextLine();
        LocalDateTime departureTime = LocalDateTime.parse(dtime);
        s.nextLine();

        System.out.println("Enter arrival Time");
        String atime = s.nextLine();
        LocalDateTime arrivalTime = LocalDateTime.parse(atime);
        s.nextLine();


        switch (ticketType) {
            case 1: {
                BusTicket busTicket = new BusTicket(bookingref,origin,destination,price,departureTime,arrivalTime,null);
                System.out.println(busTicket);
                break;
            }
            case 2: {
                System.out.println("Enter the Travel Class");
                String tClass = s.nextLine();
                TravelClass travelClass = TravelClass.valueOf(tClass.toUpperCase());

                System.out.println("Enter CarriageNumber");
                Integer carriageName = s.nextInt();
                s.nextLine();

                System.out.println("Enter Seat Number");
                Integer seatNumber = s.nextInt();
                s.nextLine();

                TrainTicket trainTicket = new TrainTicket(bookingref,origin,destination,price,departureTime,arrivalTime,travelClass,carriageName,seatNumber);
                System.out.println(trainTicket);
                break;
            }
            case 3: {
                System.out.println("Enter the Travel Class");
                String tClass = s.nextLine();
                TravelClass travelClass = TravelClass.valueOf(tClass.toUpperCase());

                System.out.println("Enter Seat Number");
                Integer seatNumber = s.nextInt();
                s.nextLine();

                System.out.println("Enter stopOvers");
                Integer stopOvers = s.nextInt();
                s.nextLine();

                PlainTicket plainTicket = new PlainTicket(bookingref,origin,destination,price,departureTime,arrivalTime,travelClass,seatNumber,stopOvers);
                System.out.println(plainTicket);
                break;
            }
        }
    }
}
