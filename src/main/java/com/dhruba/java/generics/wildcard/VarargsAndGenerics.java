package com.dhruba.java.generics.wildcard;

import java.util.Arrays;

public class VarargsAndGenerics {
	
	public static void main(String[] args) {
		Integer[] integers = arrayOf(1,2);//[1, 2]
		System.out.println(Arrays.toString(integers));//class [Ljava.lang.Integer;
		System.out.println(integers.getClass());
		
		Object[] strs = pair("a");
		System.out.println(Arrays.toString(strs));
		System.out.println(strs.getClass());
		
		Integer[] pair = pair(1); //This is due to heap pollution
		/*
		 
		 [a, a]
		class [Ljava.lang.Object;
		java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
		at com.dhruba.java.generics.wildcard.VarargsAndGenerics.main(VarargsAndGenerics.java:16)
		 
		 */
		System.out.println(Arrays.toString(pair));
		System.out.println(pair.getClass());
	}
	
	//The code below is very unsafe code since they cause heap pollution
	
	private static <T> T[] pair(T t) {
		return arrayOf(t, t);
	}
	
	private static <T> T[] arrayOf(T ... values) {
		return values;
	}
}
