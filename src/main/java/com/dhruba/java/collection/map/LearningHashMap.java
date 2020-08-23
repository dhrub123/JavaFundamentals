package com.dhruba.java.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LearningHashMap {
	
	public static void main(String[] args) {
		createAndIterateHashMap();
		System.out.println("---------");
		String name = "Aman";
		System.out.println(name.hashCode() & (16-1));
	}
	
	public static Map<Integer,String> createAndIterateHashMap() {
		
		Set<Entry<Integer,String>> entries;
		Iterator<Entry<Integer, String>> mapIterator;
		
		Map<Integer,String> students = new HashMap<Integer,String>();
		students.put(1, "Pocha");
		students.put(2, "Pochi");
		students.put(3, "Pochu");
		students.put(4, "Pocho");
		students.put(null, "Poche");
		students.put(5, null);
		students.put(6, null);
		
		entries = students.entrySet();
		mapIterator = entries.iterator();
		while(mapIterator.hasNext()) {
			Entry<Integer, String> mapEntry = mapIterator.next();
			System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
		}
		
		System.out.println("---------");
		students.remove(5);
		students.remove(6);
		students.remove(null);
		
		entries = students.entrySet();
		mapIterator = entries.iterator();
		while(mapIterator.hasNext()) {
			Entry<Integer, String> mapEntry = mapIterator.next();
			System.out.println(mapEntry.getKey() + " " + mapEntry.getValue());
		}
		
		return students;
	}

}
