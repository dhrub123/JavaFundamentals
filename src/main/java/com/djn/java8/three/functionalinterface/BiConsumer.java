package com.djn.java8.three.functionalinterface;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;

public class BiConsumer {

    public static void main(String[] args) {

        //A biconsumer has 2 inputs but does not return anything
        java.util.function.BiConsumer<String,String> biconsumerLambda = (a, b) -> System.out.println(a + " " + b);
        biconsumerLambda.accept("Hello", " There");

        java.util.function.BiConsumer<Integer,Integer> productLambda = (a, b) -> System.out.println("Product = " + a*b);
        java.util.function.BiConsumer<Integer,Integer> quotientLambda = (a, b) -> {
            if(b>0){
                System.out.println("Product = " + a/b);
            }
        };
        productLambda.andThen(quotientLambda).accept(50,20);
        //use predicate to print student details
        printStudentNameandActivities();
    }

    public static void printStudentNameandActivities(){
        System.out.println("printStudentNameandActivities : ");
        List<Student> students = StudentDatabase.getAllStudents();
        java.util.function.BiConsumer<String,List<String>> studentDetailsPrinterlambda = (a, b) -> System.out.println(a + " : " + b);
        students.forEach((student) -> studentDetailsPrinterlambda.accept(student.getName(),student.getActivities()));
    }
}
