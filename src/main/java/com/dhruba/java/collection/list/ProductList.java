package com.dhruba.java.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.dhruba.java.collection.arrays.Product;

public class ProductList {
	public static void main(String[] args) {
		Product door = new Product("Wooden Door", 35);
		Product floorPanel = new Product("Floor Panel", 25);
		Product window = new Product("Window", 10);
		Collection<Product> products = new ArrayList<>();
		products.add(door);products.add(floorPanel);products.add(window);
		
		System.out.println("Size = " + products.size() + ", Empty ? = " 
				+ products.isEmpty() + ", Contains windows ? = " + products.contains(window));
		System.out.println("Window removed ? = " + products.remove(window) 
			+ ", Contains windows ? = " + products.contains(window));
		products.add(window);
		
		Collection<Product> toRemove = new ArrayList<>();
		toRemove.add(door);toRemove.add(floorPanel);
		products.removeAll(toRemove);
		System.out.println(products);
		products.add(door);products.add(floorPanel);
		
		System.out.println(products);//one line
		//multi line, notice since it is a list, they were printed out in the order inserted
		for(Product product : products) {
			System.out.println(product);
		}
		
		for (Product product : products) {
			if (product.getWeight() > 20) {
				// This will result in concurrent modification exception 
				//since we are looping through products list and 
				//trying to modifying same collection.
				//products.remove(product); 
			}
		}
		
		//so we have to use iterator
		Iterator<Product> iterator = products.iterator();
		while(iterator.hasNext()) {
			Product product = iterator.next();
			if(product.getWeight() > 20) {
				iterator.remove();
			}
		}
		System.out.println(products);
	}
}
