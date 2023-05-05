package com.djn.java8.three.functionalinterface;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.List;

/**
 * Predicates accept input and return a boolean after processing
 * java.util.function.Predicate
 * common methods are test, and, or and negate
 */
public class Predicate {

    static java.util.function.Predicate<Integer> evenTestingPredicate = (i) -> i%2==0;
    static java.util.function.Predicate<Integer> divisiblebyFivePredicate = (i) -> i%5==0;

    public static java.util.function.Predicate<Student> gradeMoreThanThree = (student) -> student.getGradeLevel() >= 3;
    public static java.util.function.Predicate<Student> gpaMoreThan8Point5 = (student) -> student.getGpa() >= 8.5;
    public static java.util.function.Predicate<Student> genderIsFemale = (student) -> student.getGender().equals("female");

    private static void filterStudentsByGrade(List<Student> students){
        System.out.println("Grade level more than three");
        System.out.println("============================");
        students.forEach(student -> {
            if(gradeMoreThanThree.test(student)){
                System.out.println(student);
            }
        });
    }
    private static void filterStudentsByGpa(List<Student> students){
        System.out.println("GPA more than 8.5");
        System.out.println("============================");
        students.forEach(student -> {
            if(gpaMoreThan8Point5.test(student)){
                System.out.println(student);
            }
        });
    }
    private static void filterStudentsByGradeAndGpa(List<Student> students){
        System.out.println("Grade level more than three and gpa more than 8.5");
        System.out.println("============================");
        students.forEach(student -> {
            if(gpaMoreThan8Point5.and(gradeMoreThanThree).test(student)){
                System.out.println(student);
            }
        });
    }
    private static void filterStudentsByGradeOrGpa(List<Student> students){
        System.out.println("Grade level more than three or gpa more than 8.5");
        System.out.println("============================");
        students.forEach(student -> {
            if(gpaMoreThan8Point5.or(gradeMoreThanThree).test(student)){
                System.out.println(student);
            }
        });
    }
    private static void filterAndExcludeStudentsByGradeOrGpa(List<Student> students){
        System.out.println("except Grade level more than three or gpa more than 8.5");
        System.out.println("============================");
        students.forEach(student -> {
            if(gpaMoreThan8Point5.or(gradeMoreThanThree).negate().test(student)){
                System.out.println(student);
            }
        });
    }

    public static void predicateAnd(Integer input){
        System.out.println(input + " is even and divisible by 5 ? "
                + evenTestingPredicate.and(divisiblebyFivePredicate).test(input));
    }

    public static void predicateOr(Integer input){
        System.out.println(input + " is even or divisible by 5 ? "
                + evenTestingPredicate.or(divisiblebyFivePredicate).test(input));
    }

    public static void reverseResultOfPredicateAnd(Integer input){
        System.out.println("Reverse of " + input + " is even and divisible by 5 ? "
                + evenTestingPredicate.and(divisiblebyFivePredicate).negate().test(input));
    }

    public static void main(String[] args) {
        System.out.println("8 is even ? " + evenTestingPredicate.test(8));
        predicateAnd(8);
        predicateOr(8);
        reverseResultOfPredicateAnd(8);

        List<Student> students = StudentDatabase.getAllStudents();
        filterStudentsByGrade(students);
        filterStudentsByGpa(students);
        filterStudentsByGradeAndGpa(students);
        filterStudentsByGradeOrGpa(students);
        filterAndExcludeStudentsByGradeOrGpa(students);
    }
}
