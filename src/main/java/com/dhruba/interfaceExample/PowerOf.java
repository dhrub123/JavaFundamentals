package com.dhruba.interfaceExample;

public class PowerOf implements MathProcessing {
	
	private String formattedOutput;
	@Override
	public String getKeyword() {
		return "power";
	}

	public char getSymbol() {
		return '^';
	}

	public double doCalculation(double leftVal, double rightVal) {
		double product =  Math.pow(leftVal, rightVal);
		formattedOutput = leftVal + " to the power of " + rightVal + " is " + product;
		System.out.println(getFormattedOutput());
		return product;
	}
	
	@Override
	public String getFormattedOutput() {
		return formattedOutput;
	}

}
