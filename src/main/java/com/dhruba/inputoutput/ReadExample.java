package com.dhruba.inputoutput;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * Comparison between try-catch-finally and try with resources for 
 * iostreams
 *
 */
public class ReadExample {

	public static void main(String[] args) {
		//ReadExample.doTryCatchFinally("/Users/dhruba/git/JavaFundamentals/src/main/resources/Alphabets.txt");
		//ReadExample.doTryWithResources("/Users/dhruba/git/JavaFundamentals/src/main/resources/Alphabets.txt");
		//ReadExample.doTryWithMultipleResources("/Users/dhruba/git/JavaFundamentals/src/main/resources/Alphabets.txt",
		//		"/Users/dhruba/git/JavaFundamentals/src/main/resources/Alphabets-copy.txt");
		ReadExample.doCloseResources();
	}

	public static void doTryCatchFinally(String fileName) {

		char[] buffer = new char[8];
		int length;
		Reader reader = null;

		try {
			reader = Helper.openReader(fileName);
			while ((length = reader.read(buffer)) > 0) {
				System.out.println("\n\nlength = " + length + "\n");
				for (int i = 0; i < length; i++) {
					System.out.print(buffer[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
			}

		}
	}
	
	/**
	 * 
	 * Here the reader exists only within the lifecycle of try and cannot be assigned
	 */
	public static void doTryWithResources(String fileName) {

		char[] buffer = new char[8];
		int length;

		try (Reader reader = Helper.openReader(fileName)) {

			while ((length = reader.read(buffer)) > 0) {
				System.out.println("\n\nlength = " + length + "\n");
				for (int i = 0; i < length; i++) {
					System.out.print(buffer[i]);
				}
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}
	
	public static void doTryWithMultipleResources(String inputFileName, String outputFileName) {

		char[] buffer = new char[8];
		int length;

		try (Reader reader = Helper.openReader(inputFileName);
			 Writer writer = Helper.openWriter(outputFileName);	) {

			while ((length = reader.read(buffer)) > 0) {
				System.out.println("\nlength = " + length + "\n");
				writer.write(buffer, 0, length);
			}
		} catch (IOException e) {
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
		}
	}
	
	public static void doCloseResources() {
		try(CustomAutoCloseable customAutoCloseable = new CustomAutoCloseable()){
			customAutoCloseable.printMessage();
		}catch(IOException e){
			/** here even though there is no call to close, the exception is thrown from printMessage()
			 * and close() but the exception from close() is suppressed  
			 */
			System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
			for(Throwable t : e.getSuppressed()){
				System.out.println("Supressed Exception - " + t.getMessage());
			}
		}
	}
	
}
