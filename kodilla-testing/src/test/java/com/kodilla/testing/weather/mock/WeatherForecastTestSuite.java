package com.kodilla.testing.weather.mock;

//import com.kodilla.testing.weather.stub.Temperatures;
//import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    static Map<String, Double> temperaturesMap = new HashMap<>();
    static int counter = 1;

    @BeforeEach
    public void before() {
        System.out.println("Test Case " + counter + ": begin");
    }
    @AfterEach
    public void after() {
        System.out.println("Test Case " + counter + ": end");
        counter++;
    }
    @BeforeAll
    public static void beforeAll() {
        System.out.println("ShapeCollector Test Suite: begin");
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("ShapeCollector Test Suite: end");
    }

    @Mock
    private Temperatures temperaturesMock;

    @Test
    @DisplayName("check behavior while calculating forecast")
    void testCalculateForecastWithMock() {
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @Test
    @DisplayName("check behavior while calculating average")
    void testCalculateAverage() {
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = 0;
        for (Map.Entry<String, Double> entry : temperaturesMap.entrySet()) {
            result += entry.getValue();
        }
        double expected = result/temperaturesMap.size();

        double actual = weatherForecast.calculateAverage();

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("check behavior while calculating median")
    void testCalculateMedian() {
        //Given

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double actual = weatherForecast.calculateMedian();

        //Then
        Assertions.assertEquals(25.5, actual);
    }
}