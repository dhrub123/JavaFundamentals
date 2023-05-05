package com.djn.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class One_ImperativeVsDeclarative {

    public static void main(String[] args) {
        //declarative means code using inbuilt functions and
        //imperative means write logic yourself
        //find out unique integers in a list
        List<Integer> integers = Arrays.asList(1,2,2,2,3,3,3,4,4,5,6,7,7,7,7,8,8,9,9,9,9,10,10,10);
        List<Integer> uniqueList = new ArrayList<Integer>();
        for(Integer i : integers){
            if(!uniqueList.contains(i)){
                uniqueList.add(i);
            }
        }
        System.out.println("Unique list of integers is " + uniqueList);
        uniqueList = new ArrayList<Integer>();
        uniqueList = integers.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique list of integers is " + uniqueList);

        //add 100 numbers
        int sum = 0;
        for(int i = 0; i <= 100; i++){
            sum = sum + i;
        }
        System.out.println("Sum of 100 numbers in imperative way = " + sum);
        sum = 0;
        sum = IntStream.rangeClosed(0,100).sum();
        System.out.println("Sum of 100 numbers in declarative way = " + sum);
    }
}
