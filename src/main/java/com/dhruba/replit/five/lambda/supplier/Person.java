package five.lambda.supplier;

public class Person {

	String name;
	int age;
	int yearsOfService;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, int yearsOfService) {
		this.name = name;
		this.age = age;
		this.yearsOfService = yearsOfService;
	}

}
