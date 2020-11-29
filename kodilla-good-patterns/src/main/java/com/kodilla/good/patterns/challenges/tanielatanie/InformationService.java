package com.kodilla.good.patterns.challenges.tanielatanie;

import java.util.List;

public class InformationService {

    public void searchByDeparture(List<Flight> list) {
        System.out.println("\nFILTER: FLIGHTS FROM " + list.get(0).getDeparture());
        for(Flight flight : list) {
            System.out.println(flight);
        }
    }

    public void searchByArrival(List<Flight> list) {
        System.out.println("\nFILTER: FLIGHTS TO " + list.get(0).getArrival());
        for(Flight flight : list) {
            System.out.println(flight);
        }
    }
}