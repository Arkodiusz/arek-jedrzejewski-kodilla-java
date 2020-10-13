package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evens = new ArrayList<>();
        Integer e = 0;
        for(Integer i : numbers){
            //e = numbers.get(i);
            if (i%2==0) {
                evens.add(i);
            }
        }
        return evens;
    }
}
