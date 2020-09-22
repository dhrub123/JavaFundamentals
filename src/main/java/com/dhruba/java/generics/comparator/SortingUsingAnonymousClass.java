package com.dhruba.java.generics.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUsingAnonymousClass {
	
	public static void main(String[] args) {
		
		Person p2= new Person(28, "Lakshman Singh");
		Person p1= new Person(22, "Ram Singh");
		Person p3= new Person(24, "Hari Singh");
		
		List<Person> people = new ArrayList<Person>();
		people.add(p1);people.add(p2);people.add(p3);
		
		System.out.println(people);
		Collections.sort(people,new Comparator<Person>() {

			@Override
			public int compare(Person left, Person right) {
				return Integer.compare(left.getAge(), right.getAge());
			}
		});
		
		System.out.println("Sorted list = " + people);
	}
}
