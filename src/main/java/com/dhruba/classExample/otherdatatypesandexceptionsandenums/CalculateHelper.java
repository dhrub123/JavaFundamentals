package com.dhruba.classExample.otherdatatypesandexceptionsandenums;

import com.dhruba.classExample.errorsandexceptions.InvalidStatementException;
import com.dhruba.classExample.inheritance.Adder;
import com.dhruba.classExample.inheritance.CalculateBase;
import com.dhruba.classExample.inheritance.Divider;
import com.dhruba.classExample.inheritance.Multiplicator;
import com.dhruba.classExample.inheritance.Subtractor;

public class CalculateHelper {
	
	private static final char ADD_SYMBOL = '+';
	private static final char SUBTRACT_SYMBOL = '-';
	private static final char MULTIPLY_SYMBOL = '*';
	private static final char DIVIDE_SYMBOL = '/';
	
	private MathCommand command;
	private double leftValue;
	private double rightValue;
	private double result;
	
	public double getResult() {
		return result;
	}
	
	@Override
	public String toString() {
		char symbol = ' ';
		switch(command) {
			case Add:
				symbol = ADD_SYMBOL;
				break;
			case Subtract:
				symbol = SUBTRACT_SYMBOL;
				break;
			case Multiply:
				symbol = MULTIPLY_SYMBOL;
				break;
			case Divide:
				symbol = DIVIDE_SYMBOL;
				break;
		}
		
		StringBuilder sb = new StringBuilder(20);
		sb.append(leftValue).append(' ').append(symbol).append(' ').append(rightValue).append(" = ").append(result);
		return sb.toString();
	}



	public void process(String statement) throws InvalidStatementException {
		
		String[] parts = statement.split(" ");
		if(parts.length != 3) {
			throw new InvalidStatementException("Incorrect number of fields", statement);
		}
		String commandString = parts[0];
		
		try {
			leftValue = Double.parseDouble(parts[1]);
			rightValue = Double.parseDouble(parts[2]);
		}catch(NumberFormatException nfe) {
			throw new InvalidStatementException("Non numeric data", statement, nfe);
		}
		
		
		CalculateBase calculator = null;
		setCommandFromString(commandString);
		if(command == null) {
			throw new InvalidStatementException("Invalid command", statement);
		}
		
		switch(command) {
			case Add:
				calculator = new Adder(leftValue, rightValue);
				break;
			case Subtract:
				calculator = new Subtractor(leftValue, rightValue);
				break;
			case Multiply:
				calculator = new Multiplicator(leftValue, rightValue);
				break;
			case Divide:
				calculator = new Divider(leftValue, rightValue);
				break;
			default:
				break;
				
		}
		
		calculator.calculate();
		result = calculator.getResult();
	}
	
	private void setCommandFromString(String commandString) {
		if(commandString.equalsIgnoreCase(MathCommand.Add.toString())) {
			command = MathCommand.Add;
		} else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString())) {
			command = MathCommand.Subtract;
		} else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString())) {
			command = MathCommand.Multiply;
		} else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString())) {
			command = MathCommand.Divide;
		}
	}
}
