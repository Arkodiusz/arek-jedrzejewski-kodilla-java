package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTestSuite {

    @Test
    void testCorrectDepartureCorrectArrival() {
        AirportManager manager = new AirportManager();
        Flight flight1 = new Flight("Katowice", "Szczytno" );
        Flight flight2 = new Flight("Warszawa", "Warszawa" );
        assertAll(
                () -> assertDoesNotThrow(() -> manager.findFlight(flight1)),
                () -> assertDoesNotThrow(() -> manager.findFlight(flight2))
        );

    }

    @Test
    void testCorrectDepartureIncorrectArrival() {
        AirportManager manager = new AirportManager();
        Flight flight1 = new Flight("Katowice", "Hel" );
        assertThrows(RouteNotFoundException.class, () -> manager.findFlight(flight1));
    }

    @Test
    void testIncorrectDepartureCorrectArrival() {
        AirportManager manager = new AirportManager();
        Flight flight1 = new Flight("Hel", "Szczytno" );
        assertThrows(RouteNotFoundException.class, () -> manager.findFlight(flight1));
    }

    @Test
    void testIncorrectDepartureInorrectArrival() {
        AirportManager manager = new AirportManager();
        Flight flight1 = new Flight("Białystok", "Wrocław" );
        assertThrows(RouteNotFoundException.class, () -> manager.findFlight(flight1));
    }
}
