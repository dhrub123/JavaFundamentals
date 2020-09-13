package com.dhruba.java.garbagecollection;

import java.util.Random;

public class AllocationOverwrite {

	public static void main(String[] args) {
		
		int arraySize = 1000000;
		GCMe[] gcmeArray = new GCMe[arraySize];
		
		int count = 0;
		Random random = new Random();
		
		while(true) {
			gcmeArray[random.nextInt(arraySize)] = new GCMe();
			if(count % arraySize == 0) {
				System.out.println(".");
			}
			count++;
		}
	}
	
}
