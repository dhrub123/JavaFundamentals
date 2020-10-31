package com.dhruba.classExample;

public class ClassExample {
	public static void main(String[] args) {
		
		MathEquation[] equations = new MathEquation[4];
		equations[0] = new MathEquation(100.0d, 50.0d, 'd');
		equations[1] = new MathEquation(25.0d, 92.0d, 'a');
		equations[2] = new MathEquation(225.0d, 17.0d, 'm');
		equations[3] = MathEquation.create(11.0d, 3.0d, 's');
		
		for(MathEquation equation : equations) {
			equation.execute();
			System.out.println(equation.getResult());
		}
		
		System.out.println("Average result = " + MathEquation.getAverageResult());
		
		
	//		public static MathEquation create(double leftVal, double rightVal, char opCode) {
	//		MathEquation equation = new MathEquation(leftVal, rightVal, opCode);
	//		return equation;
	//	}
		
		//overload
		double leftVal = 9.0d;
		double rightVal = 4.0d;
		
		MathEquation overloadedEquation = new MathEquation('d');
		overloadedEquation.execute(leftVal, rightVal);
		System.out.println(overloadedEquation.getResult());
		
		int leftInt = 9;
		int rightInt = 4;
		overloadedEquation.execute(leftInt, rightInt);
		System.out.println(overloadedEquation.getResult());
		
		//it picks the best overload
		overloadedEquation.execute(leftVal, rightInt);
		System.out.println(overloadedEquation.getResult());
	}
	

}
