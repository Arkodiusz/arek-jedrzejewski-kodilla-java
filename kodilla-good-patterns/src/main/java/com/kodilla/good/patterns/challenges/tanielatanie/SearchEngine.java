package com.kodilla.good.patterns.challenges.tanielatanie;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private final List<Flight> list;

    public SearchEngine(List<Flight> list) {
        this.list = list;
    }

    public List<Flight> findFrom(Airport departure) {
        List<Flight> results = new ArrayList<>();
        list.stream()
                .filter(flight -> flight.getDeparture().equals(departure))
                .forEach(results::add);
        return results;
    }
}