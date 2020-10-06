package com.dhruba.java.exceptions.cutom;

public class ProcessDataException extends Exception {

	private String errorValue;

	public ProcessDataException() {
		super();
	}

	public ProcessDataException(String message) {
		super(message);
	}

	public ProcessDataException(Exception e) {
		super(e);
	}

	public String getErrorValue() {
		return errorValue;
	}

	public void setErrorValue(String errorValue) {
		this.errorValue = errorValue;
	}

}
