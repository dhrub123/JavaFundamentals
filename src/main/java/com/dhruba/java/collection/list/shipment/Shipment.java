package com.dhruba.java.collection.list.shipment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dhruba.java.collection.arrays.Product;
/**
 * 
 * Always use business domain classes.
 * Do not directly use collections in business code.
 * e.g. : Our test is using Shipment, not a list of products
 *
 */
public class Shipment implements Iterable<Product> {
	
	private static final int LIGHT_VAN_MAX_WEIGHT = 20;
	private static final int MISSING_PRODUCT = -1;
	
	private final List<Product> products = new ArrayList<Product>();
	private List<Product> heavyVanproducts = new ArrayList<Product>();
	private List<Product> lightVanproducts = new ArrayList<Product>();
	
	public void add(Product product) {
		products.add(product);
	}
	
	public boolean replace(Product oldProduct, Product newProduct) {

		int position = products.indexOf(oldProduct);
		if (position == MISSING_PRODUCT) {
			return false;
		} else {
			products.set(position, newProduct);
			return true;
		}
	}
	
	public void prepare() {
		/*for(Product product : products) {
			if(product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
				heavyVanproducts.add(product);
			}else {
				lightVanproducts.add(product);
			}
		}*/
		//sort product list
		//Collections.sort(products,Product.BY_WEIGHT);
		products.sort(Product.BY_WEIGHT);
		//find split point
		int splitPoint = findSplitPoint();
		//create 2 subviews of list
		lightVanproducts = products.subList(0,splitPoint);
		heavyVanproducts = products.subList(splitPoint,products.size());
	}
	
	private int findSplitPoint() {
		int size = products.size();
		for(int i=0; i<size; i++) {
			Product product = products.get(i);
			if(product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
				return i;
			}
		}
		return 0;
	}
	
	public List<Product> getHeavyVanProducts(){
		return heavyVanproducts;
	}
	
	public List<Product> getLightVanProducts(){
		return lightVanproducts;
	}
	
	@Override
	public Iterator<Product> iterator() {
		return products.iterator();
	}

}
