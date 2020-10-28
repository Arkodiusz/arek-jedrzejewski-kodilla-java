package com.kodilla.stream.world;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WorldTestSuite {

    @Test
    void testWorldGetPopulation() {

        //Given
        List<Country> europe = new ArrayList<>();
        List<Country> africa = new ArrayList<>();
        List<Country> asia = new ArrayList<>();

        europe.add(new Country("poland", new BigDecimal(46541454)));
        europe.add(new Country("germany", new BigDecimal(123453)));
        europe.add(new Country("france", new BigDecimal(30453300)));

        africa.add(new Country("rpa", new BigDecimal("400045545")));
        africa.add(new Country("zimbabwe", new BigDecimal("445354")));
        africa.add(new Country("kongo", new BigDecimal("604534530")));

        asia.add(new Country("russia", new BigDecimal(703355300)));
        asia.add(new Country("india", new BigDecimal(453543)));
        asia.add(new Country("mongolia", new BigDecimal(54354344)));

        List<Continent> earth = new ArrayList<>();
        earth.add(new Continent("europe", europe));
        earth.add(new Continent("africa", africa));
        earth.add(new Continent("asia", asia));

        World world = new World(earth);

        //When
        BigDecimal expected = new BigDecimal(0);

        for (Country country : europe) {
            expected = expected.add(country.getPopulation());
        }
        for (Country country : asia) {
            expected = expected.add(country.getPopulation());
        }
        for (Country country : africa) {
            expected = expected.add(country.getPopulation());
        }
        //System.out.println("expected = " + expected);

        BigDecimal actual = world.getPopulation();
        //System.out.println("actual = " + actual);

        //Then
        assertEquals(expected, actual);

    }
}
