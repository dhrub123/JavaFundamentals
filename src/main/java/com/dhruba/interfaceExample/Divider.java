package com.dhruba.interfaceExample;

public class Divider extends CalculateBase implements MathProcessing{

	
	public Divider() {}

	public Divider(double leftVal, double rightVal) {
		super(leftVal, rightVal);
	}

	@Override
	public void calculate() {
		setResult(getLeftVal() / getRightVal());

	}

	public String getKeyword() {
		return "divide";
	}

	public char getSymbol() {
		return '/';
	}

	public double doCalculation(double leftVal, double rightVal) {
		setLeftVal(leftVal);
		setRightVal(rightVal);
		calculate();
		return getResult();
	}

}
