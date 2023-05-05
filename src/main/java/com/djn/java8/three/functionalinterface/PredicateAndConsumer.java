package com.djn.java8.three.functionalinterface;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumer {

    static Predicate<Student> gradeMoreThanThree = (student) -> student.getGradeLevel() >= 3;
    static Predicate<Student> gpaMoreThan8Point5 = (student) -> student.getGpa() >= 8.5;

    //We can also combine the above two using a bipredicate
    static BiPredicate<Integer,Double> filterStudentsBasedOnMultipleConditions = (grade,gpa) -> grade >=3 && gpa >= 8.5;
    BiConsumer<String, List<String>> printStudent = (name,activities) -> System.out.println("Name = " + name
            + " activities = " + activities);
    Consumer<Student> filterAndProcessStudentConsumer = (student) -> {
      if(gradeMoreThanThree.and(gpaMoreThan8Point5).test(student)){
          printStudent.accept(student.getName(),student.getActivities());
      }
    };

    Consumer<Student> filterAndProcessStudentConsumerUsingBipredicate = (student) -> {
        if(filterStudentsBasedOnMultipleConditions.test(student.getGradeLevel(),student.getGpa())){
            printStudent.accept(student.getName(),student.getActivities());
        }
    };

    public void printStudent(List<Student> students){
        students.forEach(filterAndProcessStudentConsumer);
        System.out.println("##### Example of BiPredicate #####");
        students.forEach(filterAndProcessStudentConsumerUsingBipredicate);
    }

    public static void main(String[] args) {
        List<Student> students = StudentDatabase.getAllStudents();
        PredicateAndConsumer testClass = new PredicateAndConsumer();
        testClass.printStudent(students);
    }
}
