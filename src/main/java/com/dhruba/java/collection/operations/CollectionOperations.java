package com.dhruba.java.collection.operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dhruba.java.collection.arrays.Product;

public class CollectionOperations
{
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    public static void main(String[] args)
    {
        //var products = List.of(door,floorPanel,window); java 9 feature
    	List<Product> products = new ArrayList<Product>();
    	products.add(door);products.add(floorPanel);products.add(window);
    	Product lightestProduct = Collections.min(products, Product.BY_WEIGHT);
    	System.out.println(lightestProduct);
    	
    	Product heaviestProduct = Collections.max(products, Product.BY_WEIGHT);
    	System.out.println(heaviestProduct);
    	
    	Collections.addAll(products, door, floorPanel, window);
    	System.out.println("products = " + products);
    	
    	Collections.shuffle(products);
    	System.out.println("products = " + products);
    	
    	Collections.fill(products, null);
    	System.out.println("products = " + products);

    }
}