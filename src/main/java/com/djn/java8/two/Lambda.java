package com.djn.java8.two;

import java.util.Comparator;

public class Lambda {

    /**
     * lambda is function without name or anonymous function.
     * It has parameters, body and a return type. It can be assigned to a variable.
     *
     * (input parameters) -> {body}
     *
     * They are used to implement functional interfaces(interfaces with one abstract method)
     * like runnable or callable
     */

    public static void main(String[] args) {

        //legacy way -> anonymous class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside legacy runnable");
            }
        };
        new Thread(runnable).start();

        //new way
        Runnable runnable1 = () -> { System.out.println("Inside runnable1");};
        new Thread(runnable1).start();

        //but we do not need curly braces for a single line, but for multiple lines
        new Thread(() -> System.out.println("inside runnable2")).start();

        //legacy way for comparators
        Comparator<Integer> compareIntegers = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println("Comparison for integers using legacy = " + compareIntegers.compare(1,2));

        //new way for comparators
        Comparator<Integer> comparatorLambda = (a,b) -> a.compareTo(b);
        System.out.println("Comparison for integers using lambda = " + comparatorLambda.compare(1,2));

    }
}
