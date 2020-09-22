package com.dhruba.java.string.regex;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CaptureGroups {
	
	public static void main(String[] args) {
		/*
		 * There are 4 capture groups here.
		 * (\\w+) means one or more word characters
		 * 
		 * (-(\\w+))+ means ( -followed by a capture group of one or more word characters ) 
		 * and one or more repeatations of this capture group
		 * 
		 * -(\\w+) means - followed by a capture group of one or more word characters
		 */
		Pattern pattern = Pattern.compile("(\\w+)(-(\\w+))+-(\\w+)");
		display(pattern,"securities-development-equities-valuation-asia");
		display(pattern,"fixed_income-development-equities-asia");
		display(pattern,"fx-development-emea");
		
		
		//named capture groups
		pattern = Pattern.compile("(?<business>\\w+)(-(\\w+))+-(?<region>\\w+)");
		displayByCaptureGroupNames(pattern,"securities-development-equities-valuation-asia");
		displayByCaptureGroupNames(pattern,"fixed_income-development-equities-asia");
		displayByCaptureGroupNames(pattern,"fx-development-emea");
		
		replaceUsingCaptureGroups(pattern,"securities-development-equities-valuation-asia");
		replaceUsingCaptureGroups(pattern,"fixed_income-development-equities-asia");
		replaceUsingCaptureGroups(pattern,"fx-development-emea");
				
	}
	
	public static void display(Pattern pattern, String group) {
		Matcher matcher = pattern.matcher(group);
		int count = matcher.groupCount();
		if(matcher.matches()) {
			//groups are numbered from zero and upto count
			for(int i=0 ; i<= count; i++) {
				System.out.println(i + " " + matcher.group(i));
			}
			System.out.println("\n");
		}
	}
	
	public static void displayByCaptureGroupNames(Pattern pattern, String group) {
		Matcher matcher = pattern.matcher(group);
		if (matcher.matches()) {
			System.out.println(matcher.group(0));
			System.out.println("business = " + matcher.group("business"));
			System.out.println("business start position = " + matcher.start("business"));
			System.out.println("business end position = " + matcher.end("business"));
			System.out.println("Extracting substring " + group.substring(matcher.start("business"),matcher.end("business")));
			System.out.println("region = " + matcher.group("region"));
			System.out.println("\n");
		}
	}
	
	public static void replaceUsingCaptureGroups(Pattern pattern, String group) {
		Matcher matcher = pattern.matcher(group);
		System.out.println(matcher.replaceAll("Region:${region}, Unit:$1"));
	}
	
	
}
