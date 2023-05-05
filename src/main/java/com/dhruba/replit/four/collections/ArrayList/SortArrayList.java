package four.collections.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortArrayList {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(100);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		numbers.add(60);
		numbers.add(20);
		numbers.add(70);
		numbers.add(80);
		numbers.add(90);
		
		
		/**
		 * During Collections.sort, all elements of the list are copied to 
		 * an array and then the array is sorted. After sorting, the list is 
		 * iterated and each element is reset to a position corresponding
		 * to the array. The sorting is done using the compareTo() method of 
		 * the Comparable Interface. Wrapper classes like Integer, String etc
		 * have this implemented. For custom classes, the class needs to implement
		 * Comparable and override compareTo()
		 */
		Collections.sort(numbers);
		System.out.println("In Ascending Order " + numbers);
		
		Collections.sort(numbers, Collections.reverseOrder());
		System.out.println("In Descending Order " + numbers);
		
		//Java8 way
		List<Integer> sortedList = new ArrayList<Integer>();
		sortedList = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println("In Ascending Order using Java 8 " + sortedList);
		
		
	}

}