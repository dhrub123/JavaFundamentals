package com.djn.java8.three.functionalinterface;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;

/**
 * This comes under java.util.function and is opposite of consumer , i.e accepts nothing but returns something
 */
public class Supplier {

    static java.util.function.Supplier<List<Student>> studentSupplier = () -> StudentDatabase.getAllStudents();
    public static void main(String[] args) {

        System.out.println("List of students using supplier = " + studentSupplier.get());

    }
}
