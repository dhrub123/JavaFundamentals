package com.dhruba.java.generics.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparisonAndSortingInJava {

	public static void main(String[] args) {

		Person p2 = new Person(28, "Lakshman Singh");
		Person p1 = new Person(22, "Ram Singh");
		Person p3 = new Person(24, "Hari Singh");

		List<Person> people = new ArrayList<Person>();
		people.add(p1);
		people.add(p2);
		people.add(p3);

		System.out.println(people);
		Collections.sort(people, new AgeComparator());

		System.out.println("Sorted list = " + people);

		Collections.sort(people, new ReverseComparator<Person>(new AgeComparator()));
		System.out.println("Reverse Sorted list = " + people);

		// implementation without generics
		Person youngestPerson = (Person) min(people, new AgeComparator());
		System.out.println("Youngest person is " + youngestPerson);
		
		// implementation with generics
		youngestPerson = genericMin(people, new AgeComparator());
		System.out.println("Youngest person is " + youngestPerson);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);numbers.add(2);numbers.add(3);
		
		System.out.println(genericMin(numbers, Integer::compare));
	}
	
	//implementation without generics
	public static Object min(List values, Comparator comparator) {

		if (values.isEmpty()) {
			throw new IllegalArgumentException("List is empty, cannot find minimum ");
		}

		Object lowestElement = values.get(0);
		for (int i = 1; i < values.size(); i++) {

			Object currentElement = values.get(i);
			if (comparator.compare(currentElement, lowestElement) < 0) {
				lowestElement = currentElement;
			}
		}
		return lowestElement;
	}
	
	//implementation without generics
	public static <T> T genericMin(List<T> values, Comparator<T> comparator) {

		if (values.isEmpty()) {
			throw new IllegalArgumentException("List is empty, cannot find minimum ");
		}

		T lowestElement = values.get(0);
		for (int i = 1; i < values.size(); i++) {

			T currentElement = values.get(i);
			if (comparator.compare(currentElement, lowestElement) < 0) {
				lowestElement = currentElement;
			}
		}
		return lowestElement;
	}
}
