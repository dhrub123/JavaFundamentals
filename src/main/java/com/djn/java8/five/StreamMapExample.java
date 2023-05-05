package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * map() converts a type into another type
 */
public class StreamMapExample {

    public static List<String> getStudentsList(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) //Stream<String>
                .collect(Collectors.toList()); //List<String>
    }

    public static Set<String> getStudentsSet(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getName) //Stream<String>
                .map(String::toUpperCase) //Stream<String>
                .collect(Collectors.toSet()); //Set<String>
    }
    public static void main(String[] args) {
        System.out.println(getStudentsList());
        System.out.println(getStudentsSet());
    }
}
