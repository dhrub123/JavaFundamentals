package com.dhruba.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LearnCollections {
	
	public static void main(String[] args) {
		List<String> Students = createArrayList();
		Collections.sort(Students);
		iterateArrayListUsingIterator(Students);
		System.out.println("-------------------");
		Collections.sort(Students,Collections.reverseOrder());
		iterateArrayListUsingIterator(Students);
		System.out.println("-------------------");
		
	}
	
	public static List<String> createArrayList() {
		List<String> students = new ArrayList<String>();
		students.add("Dhruba");
		students.add("Dayita");
		students.add("Ayan");
		students.add("Pinaki");
		return students;
	}
	
	public static void iterateArrayListUsingIterator(List<String> students) {
		Iterator<String> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
