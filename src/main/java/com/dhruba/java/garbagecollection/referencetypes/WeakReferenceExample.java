package com.dhruba.java.garbagecollection.referencetypes;

import java.lang.ref.WeakReference;

public class WeakReferenceExample {
	
	public static void main(String[] args) {

		Person p1 = new Person();
		WeakReference<Person> weakReference = new WeakReference<Person>(p1);
		System.out.println("p1 " + p1);

		p1 = null;
		Person p2 = weakReference.get();
		System.out.println("p2 " + p2);

		p2 = null;
		System.gc();
		p2 = weakReference.get();
		System.out.println("p2 " + p2);

	}
	
}

class Person{
	
}
