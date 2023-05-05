package com.djn.java8.four;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReference {

    /**Method reference is used where lambda wants to refer to a method
     * e.g. : Function<String,String> uppercaseConverter = (input) -> input.toUpperCase();
     * Instead of writing this, we can write
     * Function<String,String> uppercaseConverter = String::toUpperCase;
     */

    static Function<String,String> uppercaseConverter = (input) -> input.toUpperCase();
    static Function<String,String> uppercaseConverterUsingMethodReference = String::toUpperCase;

    static Consumer<Student> printStudent = System.out::println;
    static Consumer<Student> printStudentActivities = Student::printActivities;
    public static void main(String[] args) {

        /** Shortcut for lambda expressions
        * used to refer a method in a class
        * ClassName::Instance-method-name
        * ClassName::Static-method-name
        * Instance::Method-name
        **/

        System.out.println(uppercaseConverter.apply("Java8"));
        System.out.println(uppercaseConverterUsingMethodReference.apply("Java8"));

        StudentDatabase.getAllStudents().forEach(printStudent);
        System.out.println("*** List of activities ***");
        StudentDatabase.getAllStudents().forEach(printStudentActivities);
    }
}
