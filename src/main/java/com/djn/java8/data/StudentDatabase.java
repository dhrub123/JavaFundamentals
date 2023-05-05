package com.djn.java8.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDatabase {

    public static List<Student> getAllStudents(){

        Student s1 = new Student("John",4,7.8,"male", 10,Arrays.asList("swimming","drawing"));
        Student s2 = new Student("Sonia",3,9.2,"female", 7,Arrays.asList("swimming","fencing"));
        Student s3 = new Student("Sophia",3,8.8,"female", 5,Arrays.asList("swimming","drawing"));
        Student s4 = new Student("Mary",4,7.9,"female", 13,Arrays.asList("swimming","dancing"));
        Student s5 = new Student("Tam",2,8.9,"male", 17,Arrays.asList("writing","dancing"));
        Student s6 = new Student("Dory",2,8.6,"female", 9,Arrays.asList("writing","dancing","acting"));
        Student s7 = new Student("Tory",2,8.2,"female", 15,Arrays.asList("writing","swimming","acting"));
        List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6, s7);
        return students;
    }
 }
