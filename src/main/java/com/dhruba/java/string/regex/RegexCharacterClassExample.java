package com.dhruba.java.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCharacterClassExample {
	
	public static void main(String[] args) {
		testEscapeCharacter();
		testMatcherMatchesWithPattern();
	}
	
	public static void testEscapeCharacter() {
		System.out.println(
				"I favor the numbers \"22\" and 34 and \n\r A is octal \101 \n".replaceFirst("\\d", "4")
				);// I favor the numbers "42" and 34 and  A is octal A
	}
	
	public static void testMatcherMatchesWithPattern() {
		Pattern pattern = Pattern.compile("[1-9]\\d\\d\\s\\d\\d\\d\\s\\d\\d\\d\\d");
		Matcher matcher = pattern.matcher("614 401 7497");
		System.out.println(matcher.matches() ? "Phone number format is correct" : "Phone number format is incorrect");
	}
}
