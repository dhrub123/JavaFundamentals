package com.dhruba.inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderInAction {

	public static void main(String[] args) throws IOException{
		File file = new File("src/main/resources/Alphabets.txt");
		System.out.println(file.getName());
		System.out.println(file.exists());
		
		File nope = new File("src/main/resources/nope.txt");
		System.out.println(nope.getName());
		System.out.println(nope.exists());
		nope.createNewFile();
		
		Path path = Paths.get("src/main/resources/Alphabets.txt");
		
		try(//Reader reader1 = new FileReader(file);
			//BufferedReader reader = Files.newBufferedReader(path);
			Stream<String> lines = 	Files.newBufferedReader(path).lines();){
			
			//BufferedReader br = new BufferedReader(reader);
			
			/*String line = reader.readLine();
			while(line != null) {
				System.out.println(line);
				line = reader.readLine();
			}*/
			
			//OR
			
			//reader.lines().forEach(System.out::println);
			
			//OR
			lines.forEach(System.out::println);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
