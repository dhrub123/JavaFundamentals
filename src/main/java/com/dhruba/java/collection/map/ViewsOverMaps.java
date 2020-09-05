package com.dhruba.java.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.dhruba.java.collection.arrays.Product;

public class ViewsOverMaps {
	
	public static void main(String[] args) {
		final Map<Integer,Product> idToProduct = new HashMap<Integer,Product>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);
		
		Set<Integer> ids = idToProduct.keySet();
		System.out.println(ids);
		System.out.println(idToProduct);
		System.out.println();
		
		ids.remove(1);
		System.out.println(ids);
		System.out.println(idToProduct);
		System.out.println();
		
		//We cannot add using a view
		//ids.add(5); //will result in unsupported exception because we will need both key and value
		
		Collection<Product> products = idToProduct.values();
		System.out.println(products);
		System.out.println(idToProduct);
		System.out.println();
		products.remove(ProductFixtures.window);
		System.out.println(products);
		System.out.println(idToProduct);
		System.out.println();
		
		//we cannot add window to values because we will need both key and value
		
		Set<Map.Entry<Integer, Product>> entries = idToProduct.entrySet();
		for(Map.Entry<Integer, Product> entry : entries) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			
			entry.setValue(ProductFixtures.window);
		}
		System.out.println(idToProduct);
		
		//From Java 9 Map.entry
		//Map.Entry<Integer, Product> entry = Map.entry(3, ProductFixtures.window);
		//entries.add(entry);
		
	}
}
