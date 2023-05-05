package five.lambda.function.unaryoperator;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
	
	public static void main(String[] args) {
		Person person = new Person();
		UnaryOperator<Person> operator = p -> {
			p.setAge(34);
			p.setName("Alex");
			return p;
		};
		
		operator.apply(person);
		System.out.println(person.toString());
		
		//IntUnaryOperator
		IntUnaryOperator squareOperator = num -> num * num;
		System.out.println("Square of 25 is " + squareOperator.applyAsInt(25));
	}
	

}
