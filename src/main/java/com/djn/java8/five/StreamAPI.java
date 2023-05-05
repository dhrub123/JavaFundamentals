package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;
import com.djn.java8.three.functionalinterface.Predicate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream are used to iterate over collections in a declarative way
 */
public class StreamAPI {

    public static void main(String[] args) {
        /**
         * L20 to L23 forms a stream pipeline
         * This pipeline is only triggered by collect() in L23
         * filter() is intermediate operation accepting a predicate
         * collect() is terminal operation
         *
         * peek() accepts a consumer and can be used to debug
         */
        Map<String, List<String>> studentMap = StudentDatabase.getAllStudents().stream() //returns Stream<Student>
                .peek((student) -> System.out.println(student))
                .filter(Predicate.gradeMoreThanThree) //accepts a predicate, returns Stream<Student>
                .peek((student) -> System.out.println("After 1st filter " + student))
                .filter(Predicate.gpaMoreThan8Point5) //accepts a predicate, returns Stream<Student>
                .peek((student) -> System.out.println("After 2nd filter " + student))
                .filter(student -> student.getGender().equals("female"))
                .peek((student) -> System.out.println("After 3rd filter " + student))
                .collect(Collectors.toMap(Student::getName,Student::getActivities)); //returns Map

        System.out.println("StudentMap = " + studentMap);
        System.out.println("**Parallel Stream**");

        studentMap = StudentDatabase.getAllStudents().parallelStream()
                .filter(Predicate.gradeMoreThanThree)
                .filter(Predicate.gpaMoreThan8Point5)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));
        System.out.println(studentMap);

        /**
         * Difference between collection and streams
         * |--|Collection|Streams|
         * -----------------------
         * |1|Can be modified, elements added and removed| Cannot be modified once created|
         * |2|Can be accessed in any order, e.g. list.get(4)|Can only be accessed in sequence|
         * |3|Eagerly constructed|Lazy construction which means streams are created only if a terminal operation is called|
         * |4|Can be traversed n number of times | Can be traversed only once|
         *
         *
         */
        Stream<Student> studentStream= StudentDatabase.getAllStudents().stream();
        studentStream.forEach(System.out::println);
        studentStream.forEach(System.out::println);// This is going to result in error, stream has already been operated upon or closed
    }
}
