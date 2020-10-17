package com.dhruba.classExample;

public class MathEquation {
	
	private double leftVal;
	private double rightVal;
	private char opcode;
	private double result;
	
	public MathEquation(char opcode) {
		this.opcode = opcode;
	}
	
	public MathEquation(double leftVal, double rightVal, char opcode) {
		this(opcode);
		this.leftVal = leftVal;
		this.rightVal = rightVal;
	}
	
	public MathEquation() {};
	
	public double getLeftVal() {
		return leftVal;
	}

	public void setLeftVal(double leftVal) {
		this.leftVal = leftVal;
	}

	public double getRightVal() {
		return rightVal;
	}

	public void setRightVal(double rightVal) {
		this.rightVal = rightVal;
	}

	public char getOpcode() {
		return opcode;
	}

	public void setOpcode(char opcode) {
		this.opcode = opcode;
	}

	public double getResult() {
		return result;
	}
	
	public static MathEquation create(double leftVal, double rightVal, char opcode) {
		MathEquation equation = new MathEquation();
		equation.setLeftVal(leftVal);
		equation.setRightVal(rightVal);
		equation.setOpcode(opcode);
		return equation;
	}

	public void execute(double leftVal, double rightVal) {
		this.leftVal = leftVal;
		this.rightVal = rightVal;
		execute();
	}
	
	public void execute(int leftVal, int rightVal) {
		this.leftVal = leftVal;
		this.rightVal = rightVal;
		execute();
		result = (int)result;
	}
	
	public void execute() {
		switch(opcode) {
		case 'a' :
			result = leftVal + rightVal;
			break;
		case 's' :
			result = leftVal - rightVal;
			break;
		case 'm' :
			result = leftVal * rightVal;
			break;
		case 'd' :
			result = rightVal!= 0 ? leftVal/rightVal : 0.0d;
			break;
		default:
			System.out.println("Invalid Opcode" + opcode);
			result = 0.0d;
			break;
		}
	}

}
