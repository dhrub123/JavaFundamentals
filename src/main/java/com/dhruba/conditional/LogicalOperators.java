package com.dhruba.conditional;

public class LogicalOperators {
	public static void main(String[] args) {
		
		int students = 150;
		int rooms = 0;
		
		if(rooms > 0 && students/rooms > 30) {//here left hand side did not execute because right hand side was false
			System.out.println("Crowded");
		}
		
//		if(rooms > 0 & students/rooms > 30) { // here even if left hand side is false, right hand side will execute
//			System.out.println("Crowded");
//		}
	}
}
