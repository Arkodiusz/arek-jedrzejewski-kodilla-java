package com.kodilla.good.patterns.challenges.tanielatanie;

import java.sql.Time;
import java.time.Duration;

public class Flight {

    private final String code;
    private final Airport departure;
    private final Airport arrival;
    private final Time depTime;
    private final Duration duration;

    public Flight(String code, Airport departure, Airport arrival, Time depTime, Duration duration) {
        this.code = code;
        this.departure = departure;
        this.arrival = arrival;
        this.depTime = depTime;
        this.duration = duration;
    }

    public Airport getDeparture() {
        return departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    @Override
    public String toString() {
        return "Flight " + code +
                " from " + departure +
                " to " + arrival +
                ", at " + depTime +
                " (duration " + duration.toMinutes() + " minutes)";
    }
}