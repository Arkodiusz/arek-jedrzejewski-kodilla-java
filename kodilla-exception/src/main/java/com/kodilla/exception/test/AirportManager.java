package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AirportManager {

    public static Map<String, Boolean> arrivals1 = new HashMap<>();
    public static Map<String, Boolean> arrivals2 = new HashMap<>();
    public static Map<String, Boolean> arrivals3 = new HashMap<>();

    public static Map <String, Map<String, Boolean>> departures = new HashMap<>();

    public AirportManager() {
        arrivals1.put("Warszawa", false);
        arrivals1.put("Katowice", true);
        arrivals1.put("Szczytno", true);

        arrivals2.put("Warszawa", true);
        arrivals2.put("Katowice", false);
        arrivals2.put("Szczytno", true);

        arrivals3.put("Warszawa", true);
        arrivals3.put("Katowice", true);
        arrivals3.put("Szczytno", false);

        departures.put("Warszawa", arrivals1);
        departures.put("Katowice", arrivals2);
        departures.put("Szczytno", arrivals3);

    }



    public void findFlight(Flight flight) throws RouteNotFoundException {

        String arrival = flight.getArrivalAirport();
        String departure = flight.getDepartureAirport();

        if (!departures.containsKey(departure)) {
            throw new RouteNotFoundException("No such departure!");
        }
        else if (!arrivals1.containsKey(arrival) && !arrivals2.containsKey(arrival) && !arrivals3.containsKey(arrival)) {
            throw new RouteNotFoundException("No such arrival!");
        }
        else {

            long possible = departures.entrySet().stream()
                    .filter(d -> d.getKey().equals(departure))
                    .flatMap(d -> d.getValue().entrySet().stream())
                    .filter(a -> a.getKey().equals(arrival))
                    .filter(a -> a.getValue().equals(true))
                    .collect(Collectors.counting());

            //System.out.println(possible);

            if (possible == 1) {
                System.out.println("Flight from " + departure + " to " + arrival + " found :)");
            } else {
                System.out.println("Flight from " + departure + " to " + arrival + " not found :(");
            }
        }
    }
}
