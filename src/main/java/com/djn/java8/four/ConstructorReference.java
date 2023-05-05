package com.djn.java8.four;

import com.djn.java8.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

/**Used to create a class but only through supplier
 * e.g. : Student student = Student::new is not valid but
 * Supplier<Student> studentSupplier = Student::new is valid
 * There should be an empty constructor in Student class.
 *
 * We can also use functions to create a Student but appropriate constructors are needed.
 */
public class ConstructorReference {

    static Supplier<Student> studentSupplier = Student::new;
    static Function<String,Student> studentCreator = Student::new;
    public static void main(String[] args) {
        System.out.println("Student = " + studentSupplier.get());
        System.out.println("Student = " + studentCreator.apply("Emily"));
    }
}
