package com.djn.java8.five;

import com.djn.java8.data.StudentDatabase;
import com.djn.java8.three.functionalinterface.Predicate;

/**
 * Accepts a Predicate and returns a boolean
 * AllMatch --> all elements of stream must match condition
 * AnyMatch --> any elements of stream must match condition
 * NoneMatch --> no elements of stream must match condition
 */
public class StreamMatchExample {

    public static boolean allMatch(){
        return StudentDatabase.getAllStudents().stream()
                .allMatch(Predicate.gpaMoreThan8Point5); // will be false
    }
    public static boolean anyMatch(){
        return StudentDatabase.getAllStudents().stream()
                .anyMatch(Predicate.gpaMoreThan8Point5); // will be true
    }
    public static boolean noneMatch(){
        return StudentDatabase.getAllStudents().stream()
                .noneMatch(Predicate.gpaMoreThan8Point5); // will be false
    }
    public static void main(String[] args) {
        System.out.println("Result of allMatch = " + allMatch());
        System.out.println("Result of anyMatch = " + anyMatch());
        System.out.println("Result of noneMatch = " + noneMatch());
    }
}
