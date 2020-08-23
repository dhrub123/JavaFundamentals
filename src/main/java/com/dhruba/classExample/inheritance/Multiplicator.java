package com.dhruba.classExample.inheritance;

public class Multiplicator extends CalculateBase {

	
	public Multiplicator() {}

	public Multiplicator(double leftVal, double rightVal) {
		super(leftVal, rightVal);
	}

	@Override
	public void calculate() {
		setResult(getLeftVal() * getRightVal());

	}

}
