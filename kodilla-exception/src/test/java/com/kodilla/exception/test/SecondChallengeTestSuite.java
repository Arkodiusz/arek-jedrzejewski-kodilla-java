package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    public String ok  = "Done!";
    public String nok = "Parameters out of bounds!";

    @Test
    void testXGraterEqual2() {
        assertAll(
                () -> assertDoesNotThrow(() -> ExceptionHandling.handle(1.999999, 1.0)),
                () -> assertThrows(Exception.class, () -> ExceptionHandling.handle(2.0, 1.0)),
                () -> assertThrows(Exception.class, () -> ExceptionHandling.handle(2.000001, 2.0)),
                () -> assertThrows(Exception.class, () -> ExceptionHandling.handle(150000.546, 3.0))
        );
    }

    @Test
    void testYEqualTo1_5() {
        assertAll(
                () -> assertThrows(Exception.class, () -> ExceptionHandling.handle(1, 1.5)),
                () -> assertThrows(Exception.class, () -> ExceptionHandling.handle(1.5, 1.5)),
                () -> assertDoesNotThrow(() -> ExceptionHandling.handle(1, 1.499999)),
                () -> assertDoesNotThrow(() -> ExceptionHandling.handle(1.5, 1.5000001))
        );
    }

}
