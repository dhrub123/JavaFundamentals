package four.collections.Hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IterateAndSortHashSet {
	public static void main(String[] args) {
		
		//Using for loop
		Set<Integer> set = new HashSet<>();
		set.add(23);
		set.add(42);
		set.add(32);
		set.add(42);
		
		for(int i : set) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("*******************");
		
		//Using Iterator
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		System.out.println();
		System.out.println("*******************");
		//using for each
		set.forEach(System.out::println);
		
		System.out.println("*******************");
		/*
		 * It is not possible to sort a HashSet since elements are stored inside in 
		 * random order. So it needs to be converted first to ArrayList or TreeSet
		 * before we can sort it
		 */
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		System.out.println(list);
	}
}
