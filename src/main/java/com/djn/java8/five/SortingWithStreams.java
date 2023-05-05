package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingWithStreams {

    public static List<Student> sortStudentByName(){
        return StudentDatabase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
    public static List<Student> sortStudentByGPA(){
        return StudentDatabase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(Collectors.toList());
    }
    public static List<Student> sortStudentByGPADescending(){
        return StudentDatabase.getAllStudents().stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        System.out.println(sortStudentByName());
        System.out.println(sortStudentByGPA());
        System.out.println(sortStudentByGPADescending());
    }
}
