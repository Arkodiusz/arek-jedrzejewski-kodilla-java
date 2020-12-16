package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigMacTestSuite {

    @Test
    void testBigMacBuilder() {
        //Given
        BigMac bigmac = new BigMac.BigMacBuilder()
                .bun(Bun.WHEAT)
                .burgers(7)
                .sauce(Sauce.BARBECUE)
                .ingredients("beacon", "onion", "tomato")
                .build();

        //When

        //Then
        assertEquals(Bun.WHEAT, bigmac.getBun());
        assertEquals(Sauce.BARBECUE, bigmac.getSauce());
        assertEquals(7, bigmac.getBurgers());
        assertEquals("tomato",  bigmac.getIngredients().get(2));
    }
}