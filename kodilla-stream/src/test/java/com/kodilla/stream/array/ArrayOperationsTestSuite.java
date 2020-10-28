package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {

        //Given
        int[] testArray = {333,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,75};

        //When
        int sum = 0;
        for(int i=0; i<20; i++) {
            sum+=testArray[i];
        }
        double expected = (double)sum/testArray.length;

        double actual = ArrayOperations.getAverage(testArray);

        //Then
        assertEquals(expected,actual,0.0);

    }
}
