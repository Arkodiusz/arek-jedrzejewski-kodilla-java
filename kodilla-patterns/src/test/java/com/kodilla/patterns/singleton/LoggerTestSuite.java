package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void openSettingsFile() {
        logger = Logger.INSTANCE;
        logger.log("event 1");
        logger.log("event 2");
    }

    @Test
    void testLog() {
        //Given
        //When
        String log = logger.getLastLog();
        //Then
        assertEquals("event 2", log);
    }
}