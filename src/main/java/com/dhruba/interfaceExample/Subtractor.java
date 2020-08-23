package com.dhruba.interfaceExample;

public class Subtractor extends CalculateBase implements MathProcessing{

	
	public Subtractor() {}

	public Subtractor(double leftVal, double rightVal) {
		super(leftVal, rightVal);
	}

	@Override
	public void calculate() {
		setResult(getLeftVal() - getRightVal());

	}

	public String getKeyword() {
		return "subtract";
	}

	public char getSymbol() {
		return '-';
	}

	public double doCalculation(double leftVal, double rightVal) {
		setLeftVal(leftVal);
		setRightVal(rightVal);
		calculate();
		return getResult();
	}

}
