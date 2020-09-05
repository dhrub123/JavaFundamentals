package com.dhruba.java.collection.set;

import java.util.Collections;

import org.junit.Test;

import com.dhruba.java.collection.arrays.Product;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class ProductCatalogueTest {
	
	public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    @Test
    public void shouldNotRecordDuplicateProducts()
    {
        Supplier johnsGlazing = new Supplier("John's Glazing");
        johnsGlazing.getProducts().add(window);

        Supplier allPurpose = new Supplier("All Purpose Supplies Ltd.");
        Collections.addAll(allPurpose.getProducts(), door, floorPanel, window);

        ProductCatalogue catalogue = new ProductCatalogue();
        catalogue.addSupplier(johnsGlazing);
        catalogue.addSupplier(allPurpose);

        assertThat(catalogue, containsInAnyOrder(door, floorPanel, window));
    }
	
}
