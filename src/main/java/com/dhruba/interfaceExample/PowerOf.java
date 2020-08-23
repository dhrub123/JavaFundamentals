package com.dhruba.interfaceExample;

public class PowerOf implements MathProcessing {

	public String getKeyword() {
		return "power";
	}

	public char getSymbol() {
		return '^';
	}

	public double doCalculation(double leftVal, double rightVal) {
		return Math.pow(leftVal, rightVal);
	}

}
