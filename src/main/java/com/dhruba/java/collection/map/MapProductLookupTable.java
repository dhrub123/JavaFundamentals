package com.dhruba.java.collection.map;

import java.util.HashMap;
import java.util.Map;

import com.dhruba.java.collection.arrays.Product;

public class MapProductLookupTable implements ProductLookupTable {

	private Map<Integer,Product> idToProduct = new HashMap<Integer,Product>();
	
	@Override
	public Product lookUpById(int id) {
		return idToProduct.get(id);
	}

	@Override
	public void addProduct(Product productToAdd) {
		int id = productToAdd.getId();
		if(idToProduct.containsKey(id)) {
			throw new IllegalArgumentException("Cannot add product for duplicate id = " + id);
		}
		idToProduct.put(id, productToAdd);
	}

	@Override
	public void clear() {
		idToProduct.clear();
	}

}
