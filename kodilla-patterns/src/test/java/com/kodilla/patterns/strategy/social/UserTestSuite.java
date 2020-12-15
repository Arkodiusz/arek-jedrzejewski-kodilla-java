package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User mill = new Millenials("mill");
        User yGen = new YGeneration("yGen");
        User zGen = new ZGeneration("zGen");

        //When

        //Then
        assertEquals("Snapchat", mill.sharePost());
        assertEquals("Twitter", yGen.sharePost());
        assertEquals("Facebook", zGen.sharePost());
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User mill = new Millenials("mill");

        //When
        mill.setPublisher(new FacebookPublisher());

        //Then
        assertEquals("Facebook", mill.sharePost());
    }
}