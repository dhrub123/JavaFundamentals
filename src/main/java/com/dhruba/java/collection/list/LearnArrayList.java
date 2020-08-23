package com.dhruba.java.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LearnArrayList {

	public static void main(String[] args) {
		List<String> students = createArrayList();
		iterateArrayListUsingIterator(students);
		System.out.println("-------------------");
		iterateArrayListUsingForLoop(students);
		System.out.println("-------------------");
		System.out.println(students.get(0));
		System.out.println("-------------------");
		iterateArrayListOfObjectsUsingIterator(createArrayListOfObjects());
		
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

	public static void iterateArrayListUsingForLoop(List<String> students) {
		for (String studentName : students) {
			System.out.println(studentName);
		}
	}
	
	public static List<Student> createArrayListOfObjects() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Dhruba"));
		students.add(new Student(2, "Dayita"));
		students.add(new Student(3, "Ayan"));
		students.add(new Student(4, "Pinaki"));
		return students;
	}
	
	public static void iterateArrayListOfObjectsUsingIterator(List<Student> students) {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student s = iterator.next();
			System.out.println(s.getId() + " " + s.getName());
		}
	}

}
