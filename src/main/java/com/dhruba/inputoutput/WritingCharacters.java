package com.dhruba.inputoutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class WritingCharacters {

	public static void main(String[] args) {

		Path path = Paths.get("src/main/resources/nope.txt");

		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
				BufferedWriter writer1 = Files.newBufferedWriter(path, StandardOpenOption.APPEND,
						StandardOpenOption.WRITE);) {
			
			PrintWriter pw = new PrintWriter(writer);
			//pw.println("Hello World");
			pw.printf("%d %o 0x%04x\n", 12 ,8 ,248);
			
			pw = new PrintWriter(writer1);
			pw.println("Hello World");
			
			Calendar calendar = GregorianCalendar.getInstance();
			calendar.set(1969, 6, 20);
			pw.printf("Man walked on the moon on: %1$tm %1$te %1$tY" , calendar);
			pw.printf(Locale.US, "Man walked on the moon on: %1$tB %1$tA %1$tY" , calendar);
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}
