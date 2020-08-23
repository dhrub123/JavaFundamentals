package com.dhruba.classExample.otherdatatypesandexceptions;

import com.dhruba.classExample.errorsandexceptions.InvalidStatementException;

public class Executor {
	
	public static void main(String[] args) {
		
		useCalculateHelper();
	}
	
	static void useCalculateHelper() {
		String[] statements = {
				"add 1.0",
				"add xx 25.0",
				"addX 0.0 0.0",
				"divide 100.0 50.0",
				"add 25.0 92.0",
				"subtract 225.0 17.0",
				"multiply 11.0 3.0",
		};
		
		CalculateHelper helper = new CalculateHelper();
		for(String statement : statements) {
			try {
				helper.process(statement);
				System.out.println(helper);
			} catch (InvalidStatementException e) {
				System.out.println();
				System.out.println("Exception : " + e.getMessage());
				if(e.getCause() != null){
					System.out.println("Original Exception : " + e.getCause().getMessage());
				}
				//e.printStackTrace();
			}
			
		}
	}
}
