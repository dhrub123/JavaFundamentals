package com.dhruba.java.collection.map;

import java.util.HashMap;
import java.util.Map;

import com.dhruba.java.collection.arrays.Product;

public class Java8Maps {
	
	public static void main(String[] args) {
		
		Product defaultProduct = new Product(-1,  "Whatever Customer wants", 100);
		
		Map<Integer,Product> idToProduct = new HashMap<Integer,Product>();
		idToProduct.put(1, ProductFixtures.door);
		idToProduct.put(2, ProductFixtures.floorPanel);
		idToProduct.put(3, ProductFixtures.window);
		
		Product product = idToProduct.getOrDefault(4,defaultProduct);
		System.out.println(product);
		System.out.println(idToProduct.get(4));
		
		Product oldValue = idToProduct.replace(1, new Product(1, "BigDoor", 50));
		System.out.println(oldValue);
		System.out.println(idToProduct.get(1));
		
		
		System.out.println(idToProduct);
		idToProduct.replaceAll((id, prod) -> new Product(id,prod.getName(),prod.getWeight()+10));
		System.out.println(idToProduct);
		
		idToProduct.computeIfAbsent(4, id -> new Product(id, "Door Handle",5));
		System.out.println(idToProduct);
		
		idToProduct.computeIfAbsent(4, id -> new Product(id, "Door knob",5));
		System.out.println(idToProduct);//Will not update since 4 is present
		
		idToProduct.forEach((id,prod) ->{
			System.out.println(prod.getName() + " has an id of " + id);
		});
	}

}
