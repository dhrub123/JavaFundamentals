package com.djn.java8.five;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitSkipUsingReduce {

    public static Optional<Integer> sumOfLimitedElements(List<Integer> integers, int limit){
        return integers.stream()
                .limit(limit)
                .reduce((a,b) -> a + b);
    }

    public static Optional<Integer> skipAndCalculateSum(List<Integer> integers, int skip){
        return integers.stream()
                .skip(skip)
                .reduce((a,b) -> a + b);
    }
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(7,15,34,23,65,54);
        Optional<Integer> limitedSum = sumOfLimitedElements(integers,2);
        if(limitedSum.isPresent()){
            System.out.println("sum of first 2 elements = " + limitedSum.get());
        }

        Optional<Integer> skippedSum = skipAndCalculateSum(integers,3);
        if(skippedSum.isPresent()){
            System.out.println("sum of last 3 elements = " + skippedSum.get());
        }
    }
}
