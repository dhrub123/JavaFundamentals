package com.dhruba.interfaceExample;

import com.dhruba.classExample.errorsandexceptions.InvalidStatementException;

public class DynamicHelper {
	private MathProcessing[] handlers;

	public DynamicHelper(MathProcessing[] handlers) {
		this.handlers = handlers;
	}
	
	public String process(String statement) throws InvalidStatementException {
		
		String[] parts = statement.split(MathProcessing.SEPARATOR);
		if(parts.length != 3) {
			throw new InvalidStatementException("Incorrect number of fields", statement);
		}
		String keyword = parts[0];
		MathProcessing thehandler = null;
		for(MathProcessing handler : handlers) {
			if(keyword.equalsIgnoreCase(handler.getKeyword())) {
				thehandler = handler;
				break;
			}
		}
		
		double leftValue;
		double rightValue;
		try {
			leftValue = Double.parseDouble(parts[1]);
			rightValue = Double.parseDouble(parts[2]);
		}catch(NumberFormatException nfe) {
			throw new InvalidStatementException("Non numeric data", statement, nfe);
		}
		
		double result = thehandler.doCalculation(leftValue, rightValue);
		
		StringBuilder sb = new StringBuilder(20);
		sb.append(leftValue).append(' ').append(thehandler.getSymbol()).append(' ').append(rightValue).append(" = ").append(result);
		return sb.toString();
		
		
		
	}
	
}
