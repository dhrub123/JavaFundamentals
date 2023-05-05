package five.lambda.supplier;

import java.util.function.Supplier;
import java.util.function.IntSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;

public class SupplierDemo {

	static boolean isPersonEligibleForVoting(Supplier<Person> supplier, Predicate<Person> predicate) {
		return predicate.test(supplier.get());
	}

	public static void main(String[] args) {
		Supplier<Person> supplier = () -> new Person("Alex", 23);
		Predicate<Person> ageGreaterThanEighteen = p -> p.age > 18;

		System.out
				.println("Person eligible for voting : " + isPersonEligibleForVoting(supplier, ageGreaterThanEighteen));
		
		IntSupplier integerCreator = () -> (int)(Math.random() * 10);
		System.out.println(integerCreator.getAsInt());
		
		DoubleSupplier doubleCreator = () -> (int)(Math.random() * 10);
		System.out.println(doubleCreator.getAsDouble());
	}
}
