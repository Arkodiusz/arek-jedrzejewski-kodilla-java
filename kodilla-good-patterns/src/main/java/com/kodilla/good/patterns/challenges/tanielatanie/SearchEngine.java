package com.kodilla.good.patterns.challenges.tanielatanie;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final List<Flight> list;

    public SearchEngine(List<Flight> list) {
        this.list = list;
    }

    public List<Flight> searchByDeparture(Airport departure) {
        List<Flight> results = new ArrayList<>();
        list.stream()
                .filter(flight -> flight.getDeparture().equals(departure))
                .forEach(results::add);
        return results;
    }

    public List<Flight> searchByArrival(Airport arrival) {
        List<Flight> results = new ArrayList<>();
        list.stream()
                .filter(flight -> flight.getArrival().equals(arrival))
                .forEach(results::add);
        return results;
    }

    public List<Flight> searchByBothLocalizations(Airport departure, Airport arrival) {
        List<Flight> results = new ArrayList<>();
        list.stream()
                .filter(flight -> flight.getDeparture().equals(departure) && flight.getArrival().equals(arrival))
                .forEach(results::add);
        return results;
    }

    public List<List<Flight>> searchByBothLocalizationsWithChange(Airport departure, Airport arrival, Airport change) {
        List<Flight> resultsFromDeparture = new ArrayList<>();
        List<Flight> resultsFromChange = new ArrayList<>();
        List<List<Flight>> results = new ArrayList<>();

        list.stream()
                .filter(flight -> flight.getDeparture().equals(departure) && flight.getArrival().equals(change))
                .forEach(resultsFromDeparture::add);

        list.stream()
                .filter(flight -> flight.getDeparture().equals(change) && flight.getArrival().equals(arrival))
                .forEach(resultsFromChange::add);

        for(Flight first : resultsFromDeparture) {
            resultsFromChange.stream()
                    .filter(second -> {
                        long changeTime = Duration.between(first.getArrTime(), second.getDepTime()).toMinutes();
                        return changeTime >= 15 && changeTime <= 60;
                    })
                    .forEach(second -> {
                        List<Flight> connection = new ArrayList<>();
                        connection.add(first);
                        connection.add(second);
                        results.add(connection);
                    });
        }
        System.out.println(results);
        return results;
    }
}