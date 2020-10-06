package com.dhruba.java.generics.rawtypesandcompatibility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyRawTypes {
	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		list.add("abc");
		list.add(1);
		list.add(new Object());
		
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		/*
		abc
		1
		java.lang.Object@7852e922
		*/
		
		List<String> strings = list;
		for(String element : strings) {
			System.out.println(element);
		}
		/*
		Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
		at com.dhruba.java.generics.rawtypesandcompatibility.LegacyRawTypes.main(LegacyRawTypes.java:28)
		 */
	}
}
