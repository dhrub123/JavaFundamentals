package com.djn.java8.two;

public class Restrictions {

/**
 * No local variables can be reused or modified withing a lambda expression
 * This is called effectively final variables.
 * Before java8 , all variables used in anonymous functions needed to be final to avoid concurrency issues
 * But now there is no need for that.
 * Instance variables have no such restrictions
 */

static int instanceVariable = 4;

    public static void main(String[] args) {

        int localVariable = 4;
        java.util.function.Consumer<Integer> testConsumer = (i) -> {
            System.out.println("Value passed to consumer = " + i);
            System.out.println("local variable = " + localVariable);
            //localVariable++; This is not allowed
            instanceVariable++;//But this is allowed
            System.out.println("sum of local + instance variable is = " + (localVariable + instanceVariable));
        };
        //Even this is not allowed here localVariable = 6;
        testConsumer.accept(4);
    }
}
