package com.dhruba.java.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TryWithResourcesExample {
	
	public static void main(String[] args) {
		
		processFile();		
	}
	
	public static void processFile() {
		File path = new File("/usr/bin/file.txt");
		String line = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path));){
			while((line = br.readLine()) != null) {
				
				String[] items = line.split(",");
				SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYY");
				sdf.parse(items[0]);
			}
			throw new IOException("try");
		} catch (IOException | ParseException e) {
			System.err.println(e.getMessage());
			System.err.println("Suppressed Exceptions = " + e.getSuppressed().length);
			throw new RuntimeException(e);
		}
	}
}
