package com.kodilla.testing.weather.mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverage()  {
        double result = 0;

        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            result += entry.getValue();
        }
        return result/temperatures.getTemperatures().size();
    }

    public double calculateMedian()  {
        double result = 0;
        double[] temperaturesArray = new double[temperatures.getTemperatures().size()];

        int i = 0;
        for (Map.Entry<String, Double> entry : temperatures.getTemperatures().entrySet()) {
            temperaturesArray[i] = entry.getValue();
            i++;
        }

        Arrays.sort(temperaturesArray);

        int middle = temperaturesArray.length / 2;
        if (temperaturesArray.length % 2 == 0)
        {
            double left = temperaturesArray[middle - 1];
            double right = temperaturesArray[middle];
            return (left + right) / 2;
        } else {
            return temperaturesArray[middle];
        }
    }

}
