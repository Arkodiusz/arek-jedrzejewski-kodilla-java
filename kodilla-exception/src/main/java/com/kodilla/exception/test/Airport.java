package com.kodilla.exception.test;

public class Airport {

    public static void main(String[] args) {

        AirportManager manager = new AirportManager();

        Flight fl1 = new Flight("Warszawa", "Czikago" );
        Flight fl2 = new Flight("Berlin", "Wilno" );
        Flight fl3 = new Flight("Moskwa", "Hel" );

        try {
            manager.findFlight(fl1);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.findFlight(fl2);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.findFlight(fl3);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}
