package com.dhruba.java.collection.map;

import com.dhruba.java.collection.arrays.Product;

public interface ProductLookupTable {
	Product lookUpById(int id);
	void addProduct(Product productToAdd);
	void clear();
}
