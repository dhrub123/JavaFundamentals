package com.djn.java8.five;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;
import com.djn.java8.three.functionalinterface.Predicate;

public class FilterMapReduceExample {

    public static Integer getStudentNoteBookSumCount(){
        return StudentDatabase.getAllStudents().stream()
                .filter(Predicate.genderIsFemale)
                .filter(Predicate.gpaMoreThan8Point5)
                .map(Student::getNotebooks)
                //.reduce(0,(a,b)->a + b);
                .reduce(0,Integer::sum);
    }
    public static void main(String[] args) {
        System.out.println(" Notebook count for female student with gpa > 8.5 is " + getStudentNoteBookSumCount());
    }
}
