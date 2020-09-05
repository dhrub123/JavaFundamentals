package com.dhruba.java.collection.operations;

import java.util.List;

import com.dhruba.java.collection.arrays.Product;
import com.dhruba.java.collection.list.shipment.Shipment;

public class ShipmentsBreaker
{
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    public static void main(String[] args)
    {
        Shipment shipment = new Shipment();

        shipment.add(door);
        shipment.add(window);
        shipment.add(door);
        shipment.add(window);
        shipment.add(floorPanel);

        shipment.prepare();

        List<Product> lightVanProducts = shipment.getLightVanProducts();
        System.out.println("lightVanProducts = " + lightVanProducts);
        System.out.println("-----------");
        lightVanProducts.remove(window); //so by doing this we are 
        //able to modify state of shipment even though it is a private 
        //field of shipment object and have thus broken encapsulation
        //but if we use Collections.unmodifiableList(), then we will not be able to modify
        System.out.println("-----------");
        System.out.println("shipment = " + shipment.getLightVanProducts());
        System.out.println("-----------");
        shipment.forEach(prod -> System.out.println(prod));
    }
}
