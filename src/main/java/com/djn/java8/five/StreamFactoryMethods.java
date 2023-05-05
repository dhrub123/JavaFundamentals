package com.djn.java8.five;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * of --> creates a stream of items
 * iterate() and generate() --> creates infinite streams
 * generate() takes a supplier
 * iterate() takes a seed which is initial value and the function
 */
public class StreamFactoryMethods {

    public static void main(String[] args) {
        System.out.println("Example of of()");
        Stream<String> names = Stream.of("Dhruba","Debanghsu","Dayita","Mita");
        names.forEach(System.out::println);

        System.out.println("Example of iterate()");
        Stream.iterate(1,x-> x*2).limit(10).forEach(System.out::println);

        System.out.println("Example of generate()");
        Supplier<Integer> randomNumberSupplier = new Random()::nextInt;
        Stream.generate(randomNumberSupplier).limit(5).forEach(System.out::println);
    }
}
