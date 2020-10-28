package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;

public class World {

    final List<Continent> continents;

    public World(List<Continent> continents) {

        this.continents = continents;
    }

    public BigDecimal getPopulation() {
        return continents.stream()
                .flatMap(continent -> continent.getCountries().stream())
                .map(country -> country.getPopulation())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
    }

}
