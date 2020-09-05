package com.dhruba.java.collection.map;

import java.util.ArrayList;
import java.util.List;

import com.dhruba.java.collection.arrays.Product;
//This is bulky code will bad performance
public class NaiveProductLookupTable implements ProductLookupTable {
	
	private final List<Product> products = new ArrayList<>();
	
	@Override
	public Product lookUpById(final int id) {
		for(Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

	@Override
	public void addProduct(final Product productToAdd) {
		int id = productToAdd.getId();
		for (Product product : products) {
			if (product.getId() == id) {
				throw new IllegalArgumentException("Cannot add product for duplicate id = " + id);
			}
		}
		products.add(productToAdd);
	}

	@Override
	public void clear() {
		products.clear();
	}

}
