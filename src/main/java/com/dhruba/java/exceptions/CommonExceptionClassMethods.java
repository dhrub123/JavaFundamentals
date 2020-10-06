package com.dhruba.java.exceptions;

public class CommonExceptionClassMethods {
	
	public static void main(String[] args) {
		try {
			throw new Exception("Sample Exception");
		}catch(Exception e) {
			System.err.println("getMessage(): " + e.getMessage());
			System.err.println("getLocalizedMessage(): " + e.getLocalizedMessage());
			System.err.println("getCause(): " + e.getCause());
			System.err.println("printStackTrace(): ");
			e.printStackTrace();
			System.err.println("fillInStackTrace(): ");
			e.fillInStackTrace();
			e.printStackTrace();
		}
	}
	
	/**
		 getMessage(): Sample Exception
	getLocalizedMessage(): Sample Exception
	getCause(): null
	printStackTrace(): 
	java.lang.Exception: Sample Exception
		at com.dhruba.java.exceptions.CommonExceptionClassMethods.main(CommonExceptionClassMethods.java:7)
	fillInStackTrace(): 
	java.lang.Exception: Sample Exception
		at com.dhruba.java.exceptions.CommonExceptionClassMethods.main(CommonExceptionClassMethods.java:15)

	 */

}
