package four.collections.Arrays;

import java.util.Arrays;

public class ArraySearchExample {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int index = Arrays.binarySearch(numbers, 4);
		System.out.println("Searched element found at position = " + index);

		index = Arrays.binarySearch(numbers, 14);
		System.out.println("Searched element found at position = " + index);
		index = Arrays.binarySearch(numbers, 1, 5, 4);// 1 and 5 are start and end positions
		System.out.println("Searched element found at position = " + index);

		Employee[] employees = { new Employee(123, "Jay"), new Employee(124, "Roy"), new Employee(125, "Nikki"),
				new Employee(126, "Tom") };
		index = Arrays.binarySearch(employees, new Employee(124, "Roy"), (e1, e2) -> e1.geteId() - e2.geteId());
		System.out.println("Searched element found at position = " + index);

		index = Arrays.binarySearch(employees, new Employee(124, "Roy"),
				(e1, e2) -> e1.getEname().compareTo(e2.getEname()));
		System.out.println("Searched element found at position = " + index);
	}

}
