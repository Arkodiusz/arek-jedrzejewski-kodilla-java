package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class AirportManager {

        public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Czikago", true);
        flightMap.put("Polska", true);
        flightMap.put("Wilno", false);
        flightMap.put("Tibilisi", false);

        String demandedArrival = flight.getArrivalAirport();
        String departure = flight.getDepartureAirport();

        if(flightMap.containsKey(demandedArrival)) {
            for (Map.Entry<String, Boolean> entry : flightMap.entrySet()) {
                if (entry.getKey().equals(demandedArrival)) {
                    if (entry.getValue()==true) {
                        System.out.println("Flight from " + departure + " to " + demandedArrival + " found :)");
                    } else {
                        System.out.println("Flight from " + departure + " to " + demandedArrival + " not found :(");
                    }
                }
                //else {
                //    System.out.println("Flight from " + departure + " to " + demandedArrival + " not found :(");
                //}
            }
        } else {
            throw new RouteNotFoundException("No such Airport on list!");
        }
    }
}
