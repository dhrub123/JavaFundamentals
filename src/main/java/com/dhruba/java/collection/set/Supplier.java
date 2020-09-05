package com.dhruba.java.collection.set;

import java.util.ArrayList;
import java.util.List;

import com.dhruba.java.collection.arrays.Product;

public class Supplier {

	private final String name;
	private final List<Product> products = new ArrayList<>();

	public Supplier(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "Supplier{" + "name='" + name + '\'' + ", products=" + products + '}';
	}

}
