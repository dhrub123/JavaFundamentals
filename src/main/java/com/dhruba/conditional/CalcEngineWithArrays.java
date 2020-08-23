package com.dhruba.conditional;

public class CalcEngineWithArrays {
	
	public static void main(String[] args) {
		
		double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
		double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
		char[] opcodes = {'d','a','s','m'};
		
		double[] results = new double[opcodes.length];
		//For - Loop
		for(int i = 0; i< opcodes.length; i++) {
			
			if(opcodes[i] == 'a')
				results[i] = leftVals[i] + rightVals[i];
			else if(opcodes[i] == 's')
				results[i] = leftVals[i] - rightVals[i];
			else if(opcodes[i] == 'm')
				results[i] = leftVals[i] * rightVals[i];
			else if(opcodes[i] == 'd') {
				results[i] = rightVals[i]!= 0 ? leftVals[i]/rightVals[i] : 0.0d;
			}
			else {
				System.out.println("Invalid Opcode");
				results[i] = 0.0d;
			}
			System.out.println(results[i]);
			
		}
		
		System.out.println();
		//Switch - Case
		for(int i = 0; i< opcodes.length; i++) {
			switch(opcodes[i]) {
				case 'a' :
					results[i] = leftVals[i] + rightVals[i];
					break;
				case 's' :
					results[i] = leftVals[i] - rightVals[i];
					break;
				case 'm' :
					results[i] = leftVals[i] * rightVals[i];
					break;
				case 'd' :
					results[i] = rightVals[i]!= 0 ? leftVals[i]/rightVals[i] : 0.0d;
					break;
				default:
					System.out.println("Invalid Opcode");
					results[i] = 0.0d;
					break;
			}
			
			System.out.println(results[i]);
			
		}
		
		
	}
}
