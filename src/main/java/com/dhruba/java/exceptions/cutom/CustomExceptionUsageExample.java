package com.dhruba.java.exceptions.cutom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomExceptionUsageExample {
	
	public static void main(String[] args) throws ProcessDataException {
		processFile();
	}
	
	public static void processFile() throws ProcessDataException {
		File path = new File("/usr/bin/file.txt");
		String line = "";
		String[] items = null;
		
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(path));){
				while((line = br.readLine()) != null) {
					
					items = line.split(",");
					SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYY");
					sdf.parse(items[0]);
				}
			}
		} catch (IOException | ParseException e) {
			ProcessDataException pde = new ProcessDataException(e);
			pde.setErrorValue(path.getName());
			throw new ProcessDataException(e);
		} 
	}
}

