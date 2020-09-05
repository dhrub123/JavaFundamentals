package com.dhruba.java.collection.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dhruba.java.collection.arrays.Product;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class EnterTheCollector
{
    public static void main(String[] args)
    {
        Product door = new Product(1, "Wooden Door", 35);
        Product floorPanel = new Product(2, "Floor Panel", 25);
        Product window = new Product(3, "Glass Window", 10);

        List<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);
        products.add(floorPanel);
        products.add(window);
        products.add(floorPanel);

        Map<String, Long> lightProducts = products
            .stream()
            .filter(product -> product.getWeight() < 30)
            .sorted(comparingInt(Product::getWeight))
            .collect(groupingBy(Product::getName, counting()));
        	//counting() counts the number of elements
        	//For ArrayList collection.collect(Collectors.ToList())

        System.out.println(lightProducts);
    }
}
