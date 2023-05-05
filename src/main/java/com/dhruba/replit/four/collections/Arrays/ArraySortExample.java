package four.collections.Arrays;

import java.util.Arrays;

public class ArraySortExample {
	public static void main(String[] args) {
		
		Integer[] numbers = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
		Arrays.sort(numbers);
		for(int i : numbers) {
			System.out.print(i + " ");
		}
		
		Arrays.parallelSort(numbers);
		for(int i : numbers) {
			System.out.print(i + " ");
		}
	}
}
