package com.kodilla.good.patterns.challenges.tanielatanie;

import java.util.List;

public class InformationService {

    public void findFrom(List<Flight> list) {
        System.out.println("\nFILTER: FLIGHTS FROM " + list.get(0).getDeparture());
        for(Flight flight : list) {
            System.out.println(flight);
        }
    }
}