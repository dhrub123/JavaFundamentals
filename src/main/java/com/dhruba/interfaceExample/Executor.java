package com.dhruba.interfaceExample;

import com.dhruba.classExample.errorsandexceptions.InvalidStatementException;

public class Executor {
	
	public static void main(String[] args) {
		
		String[] statements = {
				"add 25.0 92.0",
				"power 5.0 2.0",
				"divide 100.0 50.0",
				"subtract 225.0 17.0",
				"multiply 11.0 3.0"
		};
		
		DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
			new Adder(),
			new PowerOf(),
			new Multiplier(),
			new Divider(),
			new Subtractor()
		});
		
		for(String statement : statements) {
			String output;
			try {
				output = helper.process(statement);
				System.out.println(output);
			} catch (InvalidStatementException e) {
				System.out.println("Exception = " + e.getMessage());
			}
			
			
		}
	}
}
