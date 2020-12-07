package com.kodilla.good.patterns.challenges.tanielatanie;

import java.util.ArrayList;
import java.util.List;



import static com.kodilla.good.patterns.challenges.tanielatanie.Connections.*;

import static com.kodilla.good.patterns.challenges.tanielatanie.InformationService.*;

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
        processSearchByBothLocalizations(gda, wro);
        processSearchByBothLocalizationsWithChange(gda, wro, kra);
    }

    private void processSearchByDeparture(Airport departure) {
        List<Flight> results = searchEngine.searchByDeparture(departure);
        info.searchByDeparture(results);
    }

    private void processSearchByArrival(Airport arrival) {
        List<Flight> results = searchEngine.searchByArrival(arrival);
        info.searchByArrival(results);
    }

    private void processSearchByBothLocalizations(Airport departure, Airport arrival) {
        List<Flight> results = searchEngine.searchByBothLocalizations(departure, arrival);
        info.searchByBothLocalizations(results);
    }

    private void processSearchByBothLocalizationsWithChange(Airport departure, Airport arrival, Airport change) {
        List<List<Flight>> results = searchEngine.searchByBothLocalizationsWithChange(departure, arrival, change);
        info.searchByBothLocalizationsWithChange(results);
    }
}