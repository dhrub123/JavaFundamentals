package com.djn.java8.three.functionalinterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Unary operator extends function and takes one input. This is used when input and output is of the same type.
 * Common method is apply.
 *
 * Binary operator extends bifunction and takes 2 inputs. This is used when both inputs and output is of the same type.
 * Common methods are apply, maxBy and minBy.
 */
public class UnaryOperatorAndBinaryOperator {

    static UnaryOperator<String> concatter = (input) -> input.concat("-default");
    static BinaryOperator<Integer> product = (a,b) -> a*b;
    static Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
    static BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
    static BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
    public static void main(String[] args) {
        System.out.println("Output of unary operator = " + concatter.apply("test"));
        System.out.println("output of binary operator = " + product.apply(2,3));
        System.out.println("max of 4 anf 5 is " + maxBy.apply(4,5));
        System.out.println("min of 4 anf 5 is " + minBy.apply(4,5));
    }
}
