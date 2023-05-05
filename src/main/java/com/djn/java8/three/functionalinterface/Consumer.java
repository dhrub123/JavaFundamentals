package com.djn.java8.three.functionalinterface;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;

public class Consumer {

    static java.util.function.Consumer<Student> studentPrinter = (student) -> System.out.println(student);
    static java.util.function.Consumer<Student> studentNamePrinter = (student) -> System.out.print(student.getName() + " : ");
    static java.util.function.Consumer<Student> studentActivitiesPrinter = (student) -> System.out.println(student.getActivities());

    public static void main(String[] args) {

        /**
         * @FunctionalInterface --> Interfaces which have only one abstract
         * method annotated with the given annotation
         *
         * New functional interfaces in Java8 - consumer, supplier, predicate, function
         * and their extensions like BiConsumer, BiPredicate, BiFunction, Unary Operator
         * and Binary Operator etc.
         *
         * All of these are under java.util.function package.
         */

        java.util.function.Consumer<String> consumerLambda = (a) -> System.out.println(a.toUpperCase());
        consumerLambda.accept("Hello There");

        //Print list of objects using consumer interface
        printStudent();
        //print specific fields from a list of objects and consumer chaining
        printStudentNameandActivities();
        //conditional consumer invocation
        printStudentNameandActivitiesBasedOnGrade();
    }

    public static void printStudent(){
        System.out.println("printStudent : ");
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach(studentPrinter);
    }

    public static void printStudentNameandActivities(){
        System.out.println("printStudentNameandActivities : ");
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach(studentNamePrinter.andThen(studentActivitiesPrinter));
    }

    public static void printStudentNameandActivitiesBasedOnGrade(){
        System.out.println("printStudentNameandActivitiesBasedOnGrade : ");
        List<Student> students = StudentDatabase.getAllStudents();
        students.forEach((student) -> {
            if(student.getGradeLevel()>3){
                studentNamePrinter.andThen(studentActivitiesPrinter).accept(student);
            }
        });
    }

}
