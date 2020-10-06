package com.dhruba.java.exceptions;

public class ExceptionObject {
	
	public static void main(String[] args) {
		Exception ex = new Exception();
		System.out.println(ex);
		System.out.println(ex.hashCode());
		
		Exception ex1 = new Exception("Exception with a message");
		System.out.println(ex1);
		
		Exception ex2 = new Exception(ex1);
		System.out.println(ex2);
		
		Exception ex3 = new Exception("Exception with a message and built from another exception", ex1);
		System.out.println(ex3);
		System.out.println(ex3.getCause());
	}
}
