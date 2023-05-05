package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;
import com.djn.java8.three.functionalinterface.Predicate;

import java.util.Optional;

/**
 * findFirst() --> returns first element in stream
 * findAny() --> returns first encountered element in stream
 * returns optional
 *
 * limit(),findFirst(),findAny(),anyMatch(),allMatch(),noneMatch() are short circuit operations.
 * These do not evaluate entire stream to get to their result.
 */
public class FindFirstAnyExample {

    public static Optional<Student> findAny(){
        return StudentDatabase.getAllStudents().stream()
                .filter(Predicate.genderIsFemale)
                .findAny();
    }
    public static Optional<Student> findFirst(){
        return StudentDatabase.getAllStudents().stream()
                .filter(Predicate.genderIsFemale)
                .findFirst();
    }
    public static void main(String[] args) {
        Optional<Student> findAnyResult = findAny();
        Optional<Student> findFirstResult = findFirst();
        if(findAnyResult.isPresent()){
            System.out.println("Find Any Result = " + findAnyResult.get());
        }
        if(findFirstResult.isPresent()){
            System.out.println("Find First Result = " + findFirstResult.get());
        }
    }
}
