package com.kodilla.good.patterns.challenges.tanielatanie;

public class Main {

    public static void main(String[] args) {

        Connections connections = new Connections();
        System.out.println(connections);

        FlightProcessor processor = new FlightProcessor(connections);

        processor.run();
    }
}