package com.hexa.travelbooking;

import com.hexa.travelbooking.Exception.InvalidTravelDurationException;
import com.hexa.travelbooking.bookingprocess.BookingSystem;
import com.hexa.travelbooking.bookingprocess.EnjoyableTouringSystem;
import com.hexa.travelbooking.domain.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidTravelDurationException {
        TrainTicket trainTicket = new TrainTicket();
        trainTicket.cancel();

        TrainTicket trainTicket1 = null;
        try {
            trainTicket1 = new TrainTicket(121L, "Puttaparthi", "Chennai", new BigDecimal("230"),
                    LocalDateTime.of(2000, 11, 12, 11, 16),
                    LocalDateTime.of(2000, 11, 12, 12, 15),
                    TravelClass.SECOND, 3, 44);
            trainTicket1.upgrade();
            trainTicket1.cancel();
        } catch (InvalidTravelDurationException e) {
            e.printStackTrace();
        }


        // String[] providers = {"First Company","Second Company","Third Company"};
        TrainTicket trainTicket2 = new TrainTicket(121L, "Puttaparthi", "Chennai", new BigDecimal("230"),
                LocalDateTime.of(2000, 11, 12, 11, 16),
                LocalDateTime.of(2000, 11, 12, 12, 15),
                TravelClass.SECOND, 3, 44);

        ArrayList<String> providers = new ArrayList();
        providers.add("First Bus Company");
        providers.add("Second Bus Company");
        providers.add("Third Bus Company");


        BusTicket busTicket1 = new BusTicket(122L, "Puttaparthi", "Chennai", new BigDecimal("230"),
                LocalDateTime.of(2000, 11, 12, 11, 15),
                LocalDateTime.of(2000, 11, 12, 12, 15), providers);


        BusTicket busTicket2 = new BusTicket(123L, "Anathapur", "Bangalore", new BigDecimal("230"),
                LocalDateTime.of(2000, 11, 12, 11, 15),
                LocalDateTime.of(2000, 11, 12, 12, 15), providers);

        BusTicket busTicket3 = new BusTicket(124L, "Puttaparthi", "Guntur", new BigDecimal("230"),
                LocalDateTime.of(2000, 11, 12, 11, 15),
                LocalDateTime.of(2000, 11, 12, 12, 15), providers);

        ArrayList<TravelTicket> tickets = new ArrayList<>();
        tickets.add(busTicket1);
        tickets.add(busTicket2);
        tickets.add(busTicket3);
        tickets.add(busTicket1);
        tickets.add(busTicket3);
        tickets.add(trainTicket2);


        PlainTicket plainTicket = new PlainTicket();

        TravelTicket foundTicket = tickets.get(2);
        System.out.println(foundTicket);

        if (foundTicket instanceof BusTicket) {
            System.out.println("This is BusTicket");
            BusTicket foundBusTicket = (BusTicket) foundTicket;
            System.out.println(foundBusTicket.getPermittedProviders());
        } else if (foundTicket instanceof TrainTicket) {
            System.out.println("This is TrainTicket");
        } else {
            System.out.println("This is Plain Ticket");
        }

        BusTicket busTicket4 = new BusTicket(foundTicket, providers);
        System.out.println(busTicket4);

        BookingSystem bookingSystem = new EnjoyableTouringSystem();

        bookingSystem.setTravelTicket(busTicket1);
        bookingSystem.requestBooking();
        bookingSystem.getStatus();


        //Collections.sort(tickets);

//        var depatureSort = (TravelTicket a, TravelTicket b) ->{
//            return a.getDepartureTime().compareTo(b.getDepartureTime());
//        };
//        BiFunction<TravelTicket,TravelTicket,Integer> depatureSort = (TravelTicket a, TravelTicket b) ->{
//            return a.getDepartureTime().compareTo(b.getDepartureTime());
//        };

        Collections.sort(tickets, (a, b) -> a.getDepartureTime().compareTo(b.getDepartureTime()));


//        Collections.sort(tickets, new Comparator<TravelTicket>() {
//            @Override
//            public int compare(TravelTicket o1, TravelTicket o2) {
//                return o1.getDestination().compareTo(o2.getDestination());
//            }
//        });

        System.out.println("Streams");
        tickets.stream().forEach(a -> System.out.println(a));

        System.out.println("Filter");

        tickets.stream().filter(a -> a.getDestination().equalsIgnoreCase("Guntur")).forEach(a -> System.out.println(a));

        List<TravelTicket> chennaiTickets = tickets.stream().filter(a -> a.getDestination().equalsIgnoreCase("chennai")).toList();
        System.out.println("Chennai Tickets");
        for (TravelTicket ticket : chennaiTickets)
            System.out.println(ticket);

        System.out.println("MAP function");

        tickets.stream().map(a -> {
            a.setPrice(a.getPrice().add(new BigDecimal("20")));
            return a;
        }).forEach(a -> System.out.println(a));


    }
}
