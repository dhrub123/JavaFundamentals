package com.dhruba.java.string.regex;

import java.util.Arrays;
import java.util.List;

public class BasicRegex {

	public static void main(String[] args) {
		System.out.println(" Pattern c.e matches abcdefg ? " + testMatches("abcdefg", "c.e")); // false
		System.out.println(" Pattern .b.d.g matches abcdefg ? " + testMatches("abcdefg", ".b.d.f.")); // true
		
		//split by comma
		testSplit("24,34,54,hike", ",").stream().forEach((element) -> System.out.println(element)); //24 34 54 hike
		
		//split by space
		testSplit("Anne of the 1000 days", " ").stream().forEach((element) -> System.out.println(element));
		
		//will return entire string since there is nothing to split on
		testSplit("Anne of the 1000 days", "xxxx").stream().forEach((element) -> System.out.println(element));
		
		//split on empty string will return every characters since there is an empty string between each character
		testSplit("Anne of the 1000 days", "").stream().forEach((element) -> System.out.println(element));
		
		//split on a dot - removes nothing because split removes matching characters from array and dot is wildcard for everything
		testSplit("Anne of the 1000 days", ".").stream().forEach((element) -> System.out.println(element));
		
		//returns empty since all a is removed
		testSplit("aaaaa", "a").stream().forEach((element) -> System.out.println(element));
		
		//removes all a
		testSplit("1234aaaaa", "a").stream().forEach((element) -> System.out.println(element));//1234
		
		//replaces one with a 1
		System.out.println(replaceAll("one + one = 2", "one", "1"));//1 + 1 = 2
		
		//replaces one with a 1 for 1st occurrence
		System.out.println(replaceFirst("one + one = 2", "one", "1"));//1 + one = 2
	}

	public static boolean testMatches(String target, String pattern) {
		return target.matches(pattern);
	}

	public static List<String> testSplit(String target, String pattern) {
		return Arrays.asList(target.split(pattern));
	}
	
	public static String replaceAll(String target, String pattern, String replacement) {
		return target.replaceAll(pattern, replacement);
	}
	
	public static String replaceFirst(String target, String pattern, String replacement) {
		return target.replaceFirst(pattern, replacement);
	}
}
