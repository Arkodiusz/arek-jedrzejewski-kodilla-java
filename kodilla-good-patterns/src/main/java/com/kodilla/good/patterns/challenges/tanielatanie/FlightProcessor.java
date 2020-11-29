package com.kodilla.good.patterns.challenges.tanielatanie;

import java.util.List;

import static com.kodilla.good.patterns.challenges.tanielatanie.Connections.*;

public class FlightProcessor {

    Connections connections;
    SearchEngine searchEngine;
    InformationService info;

    public FlightProcessor(Connections connections) {
        this.connections = connections;
        this.searchEngine = new SearchEngine(connections.getList());
        this.info = new InformationService();
    }

    public void run() {
        processSearchByDeparture(gda);
        processSearchByArrival(wro);
    }

    private void processSearchByDeparture(Airport airport) {
        List<Flight> results = searchEngine.searchByDeparture(airport);
        info.searchByDeparture(results);
    }

    private void processSearchByArrival(Airport airport) {
        List<Flight> results = searchEngine.searchByArrival(airport);
        info.searchByArrival(results);
    }
}