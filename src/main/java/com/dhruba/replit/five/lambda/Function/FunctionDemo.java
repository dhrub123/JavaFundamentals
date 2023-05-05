package five.lambda.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {

	static int i = 0;

	public static void main(String[] args) {

		Function<String, Integer> lengthFunction = str -> str.length();
		System.out.println("Length of String is " + lengthFunction.apply("Hello, Welcome to functions"));

		Function<Integer, Integer> increment = x -> x + 20;
		Function<Integer, Integer> multiplyByTwo = y -> y * 2;
		System.out.println("(4*2) + 20 = " + increment.compose(multiplyByTwo).apply(4));

		System.out.println("(4 + 20)*2 = " + increment.andThen(multiplyByTwo).apply(4));

		// Bifunction
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println("4 + 3 = " + add.apply(4, 3));

		// capturing lambdas
		i = 5;// here even though we have reassigned i, code is compiling because it is a
		// local variable
		Function<Integer, Integer> newIncrement = x -> x + i;
		System.out.println(newIncrement.apply(i));

		int j = 7;
		j = 9;
		// Function<Integer, Integer> anotherNewIncrement = x -> x + j; --> This will
		// not compile because a local variable must be final or effectively final
		// System.out.println(newIncrement.apply(j));

	}
}
