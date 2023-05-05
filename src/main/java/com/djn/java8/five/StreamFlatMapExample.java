package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * flatMap() converts a type into another type
 * when we are a dealing with a list of collections
 * like Stream<List<String>> etc.
 *
 * distinct --> provides unique elements
 * count --> returns a long of the number of elements
 * sorted --> returns the elements sorted in natural order
 */
public class StreamFlatMapExample {

    public static List<String> getStudentActivitiesList(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                //.flatMap(Student -> Student.getActivities().stream()) //We can also write like this
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .collect(Collectors.toList()); //List<String>
    }

    public static Set<String> getStudentActivitiesSet(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                //.peek(act -> System.out.println("activities to collect is " + act))
                .collect(Collectors.toSet()); //Set<String>
    }

    public static List<String> getDistinctStudentActivitiesList(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                //.flatMap(Student -> Student.getActivities().stream()) //We can also write like this
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .distinct() //Stream<String>
                .collect(Collectors.toList()); //List<String>
    }

    public static long getStudentActivitiesCount(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                //.flatMap(Student -> Student.getActivities().stream()) //We can also write like this
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .count(); //long
    }

    public static List<String> getSortedStudentActivitiesList(){
        return StudentDatabase.getAllStudents().stream() //Stream<Student>
                //.flatMap(Student -> Student.getActivities().stream()) //We can also write like this
                .map(Student::getActivities) //Stream<List<String>>
                .flatMap(List::stream) //Stream<String>
                .sorted() //Stream<String>
                .collect(Collectors.toList()); //List<String>
    }
    public static void main(String[] args) {
        System.out.println("getStudentActivitiesList = " + getStudentActivitiesList());
        System.out.println("getStudentActivitiesSet = " + getStudentActivitiesSet());
        System.out.println("getDistinctStudentActivitiesList = " + getDistinctStudentActivitiesList());
        System.out.println("getStudentActivitiesCount = " + getStudentActivitiesCount());
        System.out.println("getSortedStudentActivitiesList = " + getSortedStudentActivitiesList());
    }
}
