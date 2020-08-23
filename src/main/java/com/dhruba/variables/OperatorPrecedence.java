package com.dhruba.variables;

public class OperatorPrecedence {
	
	public static void main(String[] args) {
		int valA = 21;
		int valB = 6;
		int valC = 3;
		int valD = 1;
		
		System.out.println(valA - valB / valC); //21 - (6/3) = 19
		System.out.println((valA - valB) / valC); //(21 - 6)/3 = 5
		System.out.println(valA/valC * valD + valB); // ((21/3)*1) + 6 = 13
		System.out.println(valA/(valC * (valD + valB)));// 21/(3*(6+1)) = 1
	}
}
