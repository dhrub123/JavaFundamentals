package com.dhruba.java.collection.set;

import java.util.HashSet;
import java.util.Iterator;

public class LearnHashSet {
	
	public static void main(String[] args) {
		
		HashSet<String> students = createHashSet();
		iterateHashSet(students);
	}
	
	public static HashSet<String> createHashSet() {
		HashSet<String> students = new HashSet<String>();
		students.add("Dhruba");
		students.add("Dayita");
		students.add("Ayan");
		students.add("Pinaki");
		students.add("Pinaki");
		students.add(null);
		return students;
	}
	
	public static void iterateHashSet(HashSet<String> students) {
		Iterator<String> student = students.iterator();
		while(student.hasNext()) {
			System.out.println(student.next());
		}
	}

}
