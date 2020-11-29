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
        processFindFrom(gda);
    }

    private void processFindFrom(Airport departure) {
        List<Flight> results = searchEngine.findFrom(departure);
        info.findFrom(results);
    }
}