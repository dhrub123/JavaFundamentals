package four.collections.ArrayList.Comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(21, "Sam"));
		employees.add(new Employee(19, "John"));
		employees.add(new Employee(37, "Lisa"));
		
		Collections.sort(employees);
		System.out.println(employees);
	}

}