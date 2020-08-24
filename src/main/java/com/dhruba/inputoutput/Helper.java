package com.dhruba.inputoutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Helper {

	public static Reader openReader(String fileName) {

		Reader reader = null;
		try {
			reader = new FileReader(fileName);

		} catch (FileNotFoundException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
		return reader;
	}

	public static Writer openWriter(String fileName) {

		Writer writer = null;
		try {
			writer = new FileWriter(fileName);

		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
		return writer;
	}
}
