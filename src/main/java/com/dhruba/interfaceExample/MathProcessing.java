package com.dhruba.interfaceExample;

public interface MathProcessing {
	
	String SEPARATOR = " ";
	String getKeyword();
	char getSymbol();
	double doCalculation(double leftVal, double rightVal);
	default String getFormattedOutput() {
		return null;
	}
	

}
