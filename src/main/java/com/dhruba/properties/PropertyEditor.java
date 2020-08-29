package com.dhruba.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyEditor {
	public static void main(String[] args) {
		try {
			Properties defaultProperties = new Properties();
			try (InputStream inputStream = PropertyEditor.class.getResourceAsStream("DefaultValues.xml")) {
				defaultProperties.loadFromXML(inputStream);
			}
			Properties userProperties = new Properties(defaultProperties);
			loadUserProperties(userProperties);
			
			String welcomeMessage = userProperties.getProperty("welcomeMessage"); 
			String farewellMessage = userProperties.getProperty("farewellMessage");
			
			System.out.println(welcomeMessage + " " + farewellMessage);
			
			if(userProperties.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
				userProperties.setProperty("welcomeMessage", "Welcome Back"); 
				userProperties.setProperty("farewellMessage", "Bye Again");
				userProperties.setProperty("isFirstRun", "N");
				saveUserProperties(userProperties);
			}
			
		} catch (IOException iex) {
			System.out.println("Exception < " + iex.getClass().getSimpleName() + "> " + iex.getMessage());
		}

	}
	
	private static Properties loadUserProperties(Properties userProperties) throws IOException{
		Path userFile = Paths.get("userValues.xml");
		if(Files.exists(userFile)) {
			try(InputStream inputStream = Files.newInputStream(userFile)){
				userProperties.loadFromXML(inputStream);
			}
		}
		return userProperties;
	}
	
	private static void saveUserProperties(Properties userProperties) throws IOException {
		try(OutputStream outputStream = Files.newOutputStream(Paths.get("userValues.xml"))){
			userProperties.storeToXML(outputStream, null);
		}
	}
}
