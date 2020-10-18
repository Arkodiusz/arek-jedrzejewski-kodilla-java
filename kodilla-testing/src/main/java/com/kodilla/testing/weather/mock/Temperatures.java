package com.kodilla.testing.weather.mock;

import java.util.Map;

public interface Temperatures {

    //first element of the map is an identifier of weather station
    //second element of the map is a temperature in Celsius degrees

    Map<String, Double> getTemperatures();
}