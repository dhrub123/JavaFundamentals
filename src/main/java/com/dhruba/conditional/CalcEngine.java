package com.dhruba.conditional;

public class CalcEngine {
	
	public static void main(String[] args) {
		
		double val1 = 100;
		double val2 = 50;
		
		double result;
		
		char opcode = 'd';
		
		if(opcode == 'a')
			result = val1 + val2;
		else if(opcode == 's')
			result = val1 - val2;
		else if(opcode == 'm')
			result = val1 * val2;
		else if(opcode == 'd') {
			result = val2!= 0 ? val1/val2 : 0.0d;
			/*if(val2 != 0) {
				result = val1 / val2;
			}else {
				result = 0.0d;
			}*/
		}
		else {
			System.out.println("Invalid Opcode");
			result = 0.0d;
		}
		System.out.println(result);
	}
}
