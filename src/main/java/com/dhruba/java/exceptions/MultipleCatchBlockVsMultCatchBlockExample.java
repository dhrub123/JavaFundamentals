package com.dhruba.java.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MultipleCatchBlockVsMultCatchBlockExample {
	
	public static void main(String[] args) {
		
		BufferedReader br = null;
		File path = new File("/usr/bin/file.txt");
		String line = "";
		
		try {
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null) {
				
				String[] items = line.split(",");
				SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYY");
				sdf.parse(items[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/**
		 * MULTI CATCH BLOCK
		 */
		
		try {
			br = new BufferedReader(new FileReader(path));
			while((line = br.readLine()) != null) {
				
				String[] items = line.split(",");
				SimpleDateFormat sdf = new SimpleDateFormat("DDMMYYYY");
				sdf.parse(items[0]);
			}
		} catch (IOException | ParseException e) {
			System.err.println(e.getMessage());
		}finally {
			System.out.println("We are in finally");
			try {
				if(br!= null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
