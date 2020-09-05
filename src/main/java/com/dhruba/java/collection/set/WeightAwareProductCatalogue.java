package com.dhruba.java.collection.set;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

import com.dhruba.java.collection.arrays.Product;

public class WeightAwareProductCatalogue implements Iterable<Product>{
	
	private final NavigableSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

	    public void addSupplier(final Supplier supplier)
	    {
	        products.addAll(supplier.getProducts());
	    }

	    public Set<Product> findLighterProducts(final Product product)
	    {
	        return products.headSet(product, false);
	    }

	    @Override
	    public Iterator<Product> iterator()
	    {
	        return products.iterator();
	    }
	    
}
