package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Reduce is a terminal operation meant to process or reduce values of a stream to one single value
 * It takes a identity and a binary operator where identity is the initial value and binary operator is the function to perform
 * It can also be used without an identity but in that case an optional is returned
 * Optional is introduced in java8 and is used when we are not sure if there will be values present.
 * So we check the optional with isPresent and then fo a get
 */
public class ReduceExample {

    public static Integer performMultiplication(List<Integer> integers){
        //here 1 is the identity or the initial value and function is a*b
        //1 -> 1 * identity(1) = 1
        //3 -> 3 * previous result(1) = 3
        //5 -> 5 * 3 = 15
        //7 -> 15 * 7 = 105
        return integers.stream()
                .reduce(1,(a,b) -> a*b);
    }

    public static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integers){
        return integers.stream()
                .reduce((a,b) -> a*b);
    }

    public static Optional<Student> getStudentWithHighestGPA(){
        return StudentDatabase.getAllStudents().stream()
                .reduce((student1,student2) -> student1.getGpa() > student2.getGpa() ? student1 : student2);
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5,7);
        System.out.println("Product = " + performMultiplication(integers));

        Optional<Integer> optionalOfMultiplier = performMultiplicationWithoutIdentity(integers);
        if(optionalOfMultiplier.isPresent()){
            System.out.println("Product calculated without identity = " + optionalOfMultiplier.get());
        }

        Optional<Student> optionalOfStudentWithHighestGPA = getStudentWithHighestGPA();
        if(optionalOfStudentWithHighestGPA.isPresent()){
            System.out.println("Student with highest GPA = " + optionalOfStudentWithHighestGPA.get());
        }
    }
}
