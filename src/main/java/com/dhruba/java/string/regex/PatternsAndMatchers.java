package com.dhruba.java.string.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class PatternsAndMatchers {
	
	public static void main(String[] args) {
		testSplitWithPattern(",");//12 34 56 78
		testMatcherReplaceWithPattern("/");//12-21-18
		testMatcherMatchesWithPattern("../../..");//this will return true
		
		try{
			testMatcherMatchesWithPattern("\\w\\d[]");
		}catch(PatternSyntaxException e) {
			System.out.println("Index = " + e.getIndex());
			System.out.println("Pattern = " + e.getPattern());
			System.out.println("Message = " + e.getMessage());
		}
		patternPredicate();
		splitAsStream();
		
		testMatcherLookingAtWithPattern();
		testMatcherFindWithPattern("(?<forwardslash>/)");
	}
	
	public static void testSplitWithPattern(String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		String[] split = pattern.split("12,34,56,78");
		System.out.println(Arrays.asList(split));
	}
	
	public static void testMatcherReplaceWithPattern(String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher("12/21/18");
		System.out.println(matcher.replaceAll("-"));
	}
	
	public static void testMatcherMatchesWithPattern(String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher("12/21/18");
		System.out.println(matcher.matches());
	}
	
	public static void testMatcherLookingAtWithPattern() {
		Pattern pattern = Pattern.compile("said the raven");
		Matcher matcher = pattern.matcher("said the raven, nevermore");
		if(matcher.lookingAt()) {
			System.out.println("Found while looking at " + matcher.group(0));
		}
	}
	
	public static void testMatcherFindWithPattern(String regexPattern) {
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher("12/21/18");
		while(matcher.find()) {
			System.out.println("Found at 0 " + matcher.group(0));
			System.out.println("Found at 1 " + matcher.group(1));
			System.out.println("Found at forwardslash " + matcher.group("forwardslash"));
			System.out.println(matcher.toString());
		}
	}
	
	public static void patternPredicate() {
		List<String> list = Arrays.asList("One", "Two", " ", "Buckle", "  ","My_shoe");
		Pattern pattern = Pattern.compile("\\w");
		List<String> cleanList = list.stream()
									.filter(pattern.asPredicate())
									.collect(Collectors.toList());
		System.out.println(cleanList);
	}
	
	public static void splitAsStream() {
		String text = "One, Two,  , Buckle,    ,My_shoe";
		Pattern pattern = Pattern.compile("(,\\s+)");
		List<String> list = pattern.splitAsStream(text)
									.map(String::toUpperCase)
									.collect(Collectors.toList());
		System.out.println(list);
		System.out.println("flags() " + pattern.flags() + " pattern() " + pattern.pattern() + " toString() " + pattern.toString());
	}

}
