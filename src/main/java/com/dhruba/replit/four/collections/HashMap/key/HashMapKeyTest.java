package four.collections.HashMap.key;

import java.util.HashMap;
import java.util.Map;

public class HashMapKeyTest {
	public static void main(String[] args) {
		Employee e1= new Employee(124578, "Roy");
		Employee e2= new Employee(124578, "Roy");
		Employee e3= new Employee(124576, "Bob");
		
		Map<Employee, Integer> emap = new HashMap<>();
		emap.put(e1, 28000);
		emap.put(e2, 38000);
		emap.put(e3, 45000);
		
		System.out.println(emap);
	}
}
