package com.dhruba.java.exceptions;

public class CatchExceptionExample {
	public static void main(String[] args) {
		try {
			String reversedString = reverse("abc");
			System.out.println(reversedString);

			reversedString = reverse(null);
			System.out.println(reversedString);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static String reverse(String s) throws Exception{
		if(s == null) {
			throw new Exception("String cannot be null");
		}
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString();
	}
}
