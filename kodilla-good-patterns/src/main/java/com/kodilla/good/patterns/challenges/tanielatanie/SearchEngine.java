package com.kodilla.good.patterns.challenges.tanielatanie;

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
}