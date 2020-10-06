package com.dhruba.java.exceptions;

public class ThrowExceptionExample {
	public static void main(String[] args) throws Exception {
		String reversedString = reverse("abc");
		System.out.println(reversedString);
		
		reversedString = reverse(null);
		System.out.println(reversedString);
		/*
		Exception in thread "main" java.lang.Exception: String cannot be null
	at com.dhruba.java.exceptions.ThrowExceptionExample.reverse(ThrowExceptionExample.java:14)
	at com.dhruba.java.exceptions.ThrowExceptionExample.main(ThrowExceptionExample.java:8)
		 */
	}
	
	private static String reverse(String s) throws Exception{
		if(s == null) {
			throw new Exception("String cannot be null");
		}
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
}
