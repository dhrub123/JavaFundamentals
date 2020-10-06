package com.dhruba.java.exceptions;

import java.io.IOException;
import java.text.ParseException;

public interface IThrowsExample {

	void processFile() throws IOException, ParseException;
	void processFileN() throws IOException, ParseException;

}