package seven.streams;

import java.util.ArrayList;
import java.util.List;

public class FilterDemo {

	public static void main(String[] args) {
		List<Integer> intStream = new ArrayList<>();
		intStream.add(12);intStream.add(45);intStream.add(29);intStream.add(59);
		
		intStream.stream()
				 .filter(p -> p > 15)
				 .forEach(p -> System.out.print(p + " "));
		
		System.out.println("Original list is not modified " + intStream);
		
		//Filtering with a custom Object
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Alex",23));persons.add(new Person("Xela",32));
		persons.add(new Person("Dhruba",36));persons.add(new Person("Aburhd",63));
		
		persons.stream()
		       .filter(p -> (p.age>25 && p.age<60))
		       .forEach(p -> System.out.println(p));
		
		//chain filters
		persons.stream()
			   .filter(p -> p.name != null)
			   .filter(p -> p.age > 25)
			   .filter(p -> p.age < 60)
			   .forEach(p -> System.out.println(p));

	}

}
