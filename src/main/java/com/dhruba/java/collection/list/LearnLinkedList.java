package com.dhruba.java.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LearnLinkedList {

	public static void main(String[] args) {
		LinkedList<String> students = createLinkedList();
		iterateLinkedListUsingIterator(students);
		System.out.println("-------------------");
		iterateLinkedListUsingForLoop(students);
		System.out.println("-------------------");
		System.out.println(students.get(0));
		System.out.println("-------------------");
		System.out.println(students.getFirst());
		System.out.println("-------------------");
		System.out.println(students.getLast());
		System.out.println("-------------------");
		iterateLinkedListOfObjectsUsingIterator(createLinkedListOfObjects());
		
	}

	public static LinkedList<String> createLinkedList() {
		LinkedList<String> students = new LinkedList<String>();
		students.add("Dhruba");
		students.add("Dayita");
		students.add("Ayan");
		students.add("Pinaki");
		return students;
	}

	public static void iterateLinkedListUsingIterator(LinkedList<String> students) {
		Iterator<String> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public static void iterateLinkedListUsingForLoop(LinkedList<String> students) {
		for (String studentName : students) {
			System.out.println(studentName);
		}
	}
	
	public static LinkedList<Student> createLinkedListOfObjects() {
		LinkedList<Student> students = new LinkedList<Student>();
		students.add(new Student(1, "Dhruba"));
		students.add(new Student(2, "Dayita"));
		students.add(new Student(3, "Ayan"));
		students.add(new Student(4, "Pinaki"));
		return students;
	}
	
	public static void iterateLinkedListOfObjectsUsingIterator(LinkedList<Student> students) {
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student s = iterator.next();
			System.out.println(s.getId() + " " + s.getName());
		}
	}

}
