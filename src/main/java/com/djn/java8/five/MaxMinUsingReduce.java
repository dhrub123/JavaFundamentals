package com.djn.java8.five;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MaxMinUsingReduce {
    /**
     * Never use default value in binary operator for reduce while
     * calculating min or max values
     */

    public static Optional<Integer> findMaxValue(List<Integer> integers){
        return integers.stream()
                .reduce((a,b) -> a>b ?a:b);
    }
    public static Optional<Integer> findMinValue(List<Integer> integers){
        return integers.stream()
                .reduce((a,b) -> a<b ?a:b);
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(7,15,34,23,65,54);
        Optional<Integer> maxValue = findMaxValue(integers);
        if(maxValue.isPresent()) {
            System.out.println("Max value is " + maxValue.get());
        }
        Optional<Integer> minValue = findMinValue(integers);
        if(minValue.isPresent()) {
            System.out.println("Min value is " + minValue.get());
        }
    }
}
