package com.dhruba.classExample.inheritance;

public class Adder extends CalculateBase {

	
	public Adder() {}

	public Adder(double leftVal, double rightVal) {
		super(leftVal, rightVal);
	}

	@Override
	public void calculate() {
		setResult(getLeftVal() + getRightVal());

	}

}
