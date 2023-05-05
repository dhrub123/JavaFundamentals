package five.lambda.function.binaryoperator;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

	public static void main(String[] args) {
		Person alex = new Person("Alex", 23);
		Person brian = new Person("Brian", 32);

		BinaryOperator<Person> operator = (p1, p2) -> {
			p1.name = p2.name;
			p1.age = p2.age;
			return p1;
		};

		operator.apply(alex, brian);
		System.out.println(alex.toString());

	}

}
