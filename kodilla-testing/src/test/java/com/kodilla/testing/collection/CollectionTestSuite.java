


package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.*;

public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }


    public Integer[] testArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,1,61,17,118,19,20};
    public Integer[] emptyArray = {};

    @DisplayName("check behavior when list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Arrays.asList(emptyArray);

        //When
        List<Integer> exterminated  = exterminator.exterminate(emptyList);

        List<Integer> evens = new ArrayList<>();
        for(Integer i : emptyList) {
            //e = numbers.get(i);
            if (i % 2 == 0) {
                evens.add(i);
            }
        }

        //Then
        Assertions.assertEquals(evens, exterminated);
    }

    @DisplayName("check behavior when list is filled")
    @Test
    void testOddNumbersExterminatorNormalList () {
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> tempList = Arrays.asList(testArray);

        //When
        List<Integer> exterminated = exterminator.exterminate(tempList);

        List<Integer> evens = new ArrayList<>();
        for(Integer i : tempList) {
            //e = numbers.get(i);
            if (i % 2 == 0) {
                evens.add(i);
            }
        }

        //Then
        Assertions.assertEquals(evens, exterminated);

    }
}