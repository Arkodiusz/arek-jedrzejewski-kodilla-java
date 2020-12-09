package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //Given
        //When
        double add = calculator.add(10, 15);
        double sub = calculator.sub(15, 10);
        double mul = calculator.mul(5, 5);
        double div = calculator.div(55, 5);
        //Then
        assertEquals(add, (10+15));
        assertEquals(sub, (15-10));
        assertEquals(mul, (5*5) );
        assertEquals(div, (55/5));
    }
}
