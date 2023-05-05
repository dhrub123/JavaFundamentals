package com.dhruba.replit.five.lambda.consumer;

import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		Consumer<String> stringConsumer = s -> System.out.println(s);
		stringConsumer.accept("Hello");

		Consumer<Integer> intConsumer = i -> System.out.println("Integer passed = " + i);
		intConsumer.accept(5);
		
		//chaining
		Consumer<String> consumer1 = s -> System.out.println(s + ", I am a ghost");
		Consumer<String> consumer2 = s -> System.out.println(s + ", I am very scary");
		consumer1.andThen(consumer2).accept("Hello");
		
		//Biconsumer
		BiConsumer<String, String> greet = (s1,s2) -> System.out.println(s1 + s2);
		greet.accept("Hello ", "There");
	}
}
 