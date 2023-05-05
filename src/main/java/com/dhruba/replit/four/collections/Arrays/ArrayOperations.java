package four.collections.Arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayOperations {

	public static void main(String[] args) {

		// Convert array to List
		int[] numbers = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
		List numbersList = Arrays.asList(numbers);
		System.out.println(numbersList);

		// check if 2 arrays are equal
		int[] numbers1 = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
		System.out.println("Both arrays are equal = " + Arrays.equals(numbers, numbers1));

		// Filling an array with default value
		Arrays.fill(numbers1, 20);
		for (int i : numbers1) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print("Copied array is ");
		/*
		 * copy array - if size of new array is greater than size of source array,
		 * remaining positions are filled with zeros
		 */
		int[] copiedArray = Arrays.copyOf(numbers, 20);
		for (int i : copiedArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		/* copyOfRange - to partially copy array */
		System.out.print("Partially Copied array is ");
		copiedArray = Arrays.copyOfRange(numbers, 0, 5);
		for (int i : copiedArray) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
