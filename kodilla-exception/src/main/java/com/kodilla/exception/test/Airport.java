package com.kodilla.exception.test;

public class Airport {

    public static void main(String[] args) {

        AirportManager manager = new AirportManager();

        Flight fl1 = new Flight("Warszawa", "Warszawa" );
        Flight fl2 = new Flight("Katowice", "Szczytno" );
        Flight fl3 = new Flight("Szczytno", "Hel" );
        Flight fl4 = new Flight("Kraków", "Warszawa" );
        Flight fl5 = new Flight("Kraków", "Hel" );

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
        try {
            manager.findFlight(fl4);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            manager.findFlight(fl5);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
