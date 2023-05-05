package com.djn.java8.three.functionalinterface;

import com.djn.java8.data.Student;
import com.djn.java8.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function belongs to java.util.function. - takes one input and provides output
 * Important methods are apply, andThen and compose.
 * compose --> appliers inner function first and then outer function
 *
 * BiFunction takes 2 inputs and provides output
 */

public class Function {

    //input is string and output is string as well
    static java.util.function.Function<String,String> caseConverter = (input) -> input.toUpperCase();
    static java.util.function.Function<String,String> concatter = (input) -> input.concat(" default");

    static java.util.function.Function<List<Student>, Map<String,Double>> gpaMapper = (students) -> {
      Map<String,Double> studentMap = new HashMap<>();
      students.forEach((student) -> {
          if(Predicate.gradeMoreThanThree.test(student)){
              studentMap.put(student.getName(),student.getGpa());
          }

      });
      return studentMap;
    };

    static java.util.function.BiFunction<List<Student>,java.util.function.Predicate<Student>, Map<String,Double>> gpaMapperUsingBiFunction
            = (students,predicate) -> {
        Map<String,Double> studentMap = new HashMap<>();
        students.forEach((student) -> {
            if(predicate.test(student)){
                studentMap.put(student.getName(),student.getGpa());
            }

        });
        return studentMap;
    };

    public static void main(String[] args) {
        System.out.println("Result is " + caseConverter.apply("Hello , World!"));
        System.out.println("Result of And Then is " + caseConverter.andThen(concatter).apply("Hello, World!"));
        System.out.println("Result of Compose is " + caseConverter.compose(concatter).apply("Hello, World!"));

        System.out.println("List of filtered students = " + gpaMapper.apply(StudentDatabase.getAllStudents()));
        System.out.println("List of filtered students using biFunction = " + gpaMapperUsingBiFunction.apply(StudentDatabase.getAllStudents(),Predicate.gradeMoreThanThree));
    }
}
