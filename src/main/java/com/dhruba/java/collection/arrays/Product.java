package com.dhruba.java.collection.arrays;

import java.util.Comparator;
import java.util.Objects;
import static java.util.Comparator.comparing;

public class Product {

	private String name;
	private int weight;
	private int id;
	

	public Product(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public Product(int id, String name, int weight) {
		this.name = name;
		this.weight = weight;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", weight=" + weight + ", id=" + id + "]";
	}

	//Pre Java 8 way
	public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>() {
		public int compare(final Product p1, final Product p2) {
			return Integer.compare(p1.getWeight(),p2.getWeight());
		}
	};
	//Java8 way
	//public static final Comparator<Product> BY_WEIGHT = Comparator.comparingInt(Product::getWeight);
	public static final Comparator<Product> BY_NAME = comparing(Product::getName);
	
	public boolean equals(final Object o)
    {
        if (!(o instanceof Product)) return false;

        final Product product = (Product) o;

        return Objects.equals(id, product.id)
            && Objects.equals(weight, product.weight)
            && Objects.equals(name, product.name);
    }

    public int hashCode()
    {
        return Objects.hash(id, name, weight);
    }
}
