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

    public void searchByBothLocalizations(List<Flight> list) {
        System.out.println("\nFILTER: FLIGHTS" +
                " FROM " + list.get(0).getDeparture() +
                " TO " + list.get(0).getArrival());
        for(Flight flight : list) {
            System.out.println(flight);
        }
    }

    public void searchByBothLocalizationsWithChange(List<List<Flight>> list) {
        System.out.println("\nFILTER: FLIGHTS" +
                " FROM " + list.get(0).get(0).getDeparture() +
                " TO " + list.get(0).get(list.get(0).size()-1).getArrival() +
                " THROUGH " + list.get(0).get(0).getArrival());

        for (List<Flight> connection : list) {
            for (Flight f : connection) {
                System.out.print(f);
                if(connection.lastIndexOf(f) != connection.size()-1) System.out.print(" -> ");
            }System.out.print("\n");
        }
    }
}