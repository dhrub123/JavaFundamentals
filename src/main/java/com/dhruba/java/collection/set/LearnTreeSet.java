package com.dhruba.java.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

public class LearnTreeSet {
	
	public static void main(String[] args) {
		
		TreeSet<String> students = createTreeSet();
		iterateTreeSet(students);
		System.out.println("-------------------");
		TreeSet<Student> studentObjects = createTreeSetOfObjects();
		iterateTreeSetOfObjects(studentObjects);
	}
	
	public static TreeSet<String> createTreeSet() {
		TreeSet<String> students = new TreeSet<String>();
		students.add("Dhruba");
		students.add("Dayita");
		students.add("Ayan");
		students.add("Pinaki");
		students.add("Pinaki");
		return students;
	}
	
	public static void iterateTreeSet(TreeSet<String> students) {
		Iterator<String> student = students.iterator();
		while(student.hasNext()) {
			System.out.println(student.next());
		}
	}
	
	public static TreeSet<Student> createTreeSetOfObjects() {
		TreeSet<Student> students = new TreeSet<Student>();
		students.add(new Student(1, "Dhruba"));
		students.add(new Student(2, "Dayita"));
		students.add(new Student(3, "Ayan"));
		students.add(new Student(4, "Pinaki"));
		students.add(new Student(4, "Pocha"));
		return students;
	}
	
	public static void iterateTreeSetOfObjects(TreeSet<Student> students) {
		Iterator<Student> student = students.iterator();
		while(student.hasNext()) {
			Student s = student.next();
			System.out.println(s.getId() + " " + s.getName());
		}
	}

}
