package com.dhruba.java.collection.arrays;

import java.util.Arrays;

public class ArrayExample {
	
	public static void main(String[] args) {
		
		Product door = new Product("Wooden Door", 35);
		Product floorPanel = new Product("Floor Panel", 25);
		Product window = new Product("Window", 10);
		
		Product[] products = {door, floorPanel};
		System.out.println(Arrays.toString(products));
		
		//Add
		//products[2] = window;//This will throw error because arrays are not resizable
		//so we will need to write methods which will essentially create a new array out of the old array
		products = add(window, products);
		System.out.println(Arrays.toString(products));
		
		//Duplicate - We cannot control duplicates
		products = add(window, products);
		System.out.println(Arrays.toString(products));
	}
	
	private static Product[] add(Product product, Product[] array) {
		int length = array.length;
		Product[] newArray = Arrays.copyOf(array, length + 1);
		newArray[length] = product;
		return newArray;
	}
	

}
