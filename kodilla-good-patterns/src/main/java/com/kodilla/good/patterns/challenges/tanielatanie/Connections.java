package com.kodilla.good.patterns.challenges.tanielatanie;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Connections {

    public static Airport wro = new Airport("WRO");
    public static Airport gda = new Airport("GDA");
    public static Airport kra = new Airport("KRA");

    private List<Flight> list = new LinkedList<>();

    public Connections() {
        add("187", gda, wro, 6, 0,  180);
        add("464", gda, wro, 13, 45, 180);
        add("121", gda, wro, 19, 30, 180);

        add("448", gda, kra, 10, 30, 120);
        add("232", gda, kra, 15, 30, 120);

        add("678", kra, wro, 13, 0, 60);
        add("997", kra, wro, 18, 15, 60);
    }

    public void add(String code, Airport departure, Airport arrival, int hour, int minute, long duration) {
        list.add(new Flight(code, departure, arrival, LocalTime.of(hour, minute, 0, 0), Duration.ofMinutes(duration)));
    }

    @Override
    public String toString() {
        String string = "\nALL AVAILABLE FLIGHTS: ";
        for(Flight f : list) string += "\n" + f;
        return string;
    }

    public List<Flight> getList() {
        return list;
    }
}