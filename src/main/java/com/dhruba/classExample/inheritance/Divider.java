package com.dhruba.classExample.inheritance;

public class Divider extends CalculateBase {

	
	public Divider() {}

	public Divider(double leftVal, double rightVal) {
		super(leftVal, rightVal);
	}

	@Override
	public void calculate() {
		setResult(getLeftVal() / getRightVal());

	}

}
