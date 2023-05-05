package four.collections.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HashMapSorting {

	public static void main(String[] args) {

		// Using a treemap
		Map<Integer, String> employeeMap = new HashMap<>();
		employeeMap.put(123, "Alex");
		employeeMap.put(342, "Ryan");
		employeeMap.put(143, "Joe");
		employeeMap.put(234, "Allen");
		employeeMap.put(432, "Roy");

		System.out.println("Unsorted map " + employeeMap);

		Map<Integer, String> sortedEmployeeMap = new TreeMap<>();
		sortedEmployeeMap.putAll(employeeMap);
		System.out.println("Sorted map " + sortedEmployeeMap);

		// Using an ArrayList
		List<Integer> keyList = new ArrayList<Integer>(employeeMap.keySet());
		Collections.sort(keyList);
		System.out.println("keys in sorted order = " + keyList);

		List<String> values = new ArrayList<String>(employeeMap.values());
		Collections.sort(values);
		System.out.println("Values in sorted order = " + values);

		// java8
		//Sorting by Key
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEach(System.out::println);
		//Sorting by Value
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEach(System.out::println);
	}

}
