package com.dhruba.java.collection.list.shipment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

import org.junit.Test;

import com.dhruba.java.collection.arrays.Product;

public class ShipmentTest {

	Product door = new Product("Wooden Door", 35);
	Product floorPanel = new Product("Floor Panel", 25);
	Product window = new Product("Window", 10);

	private Shipment shipment = new Shipment();

	@Test
	public void shouldAddItems() {
		shipment.add(door);
		shipment.add(window);

		assertThat(shipment, contains(door, window));
	}

	@Test
	public void shouldReplaceItems() {
		shipment.add(door);
		shipment.add(window);

		assertTrue(shipment.replace(door, floorPanel));
		assertThat(shipment, contains(floorPanel, window));
	}
	
	@Test
	public void shouldNotReplaceMissingItems() {
		shipment.add(window);

		assertFalse(shipment.replace(door, floorPanel));
		assertThat(shipment, contains(window));
	}
	
	@Test
	public void shouldIdentifyVanRequirements() {
		shipment.add(door);shipment.add(window);shipment.add(floorPanel);
		shipment.prepare();
		
		assertThat(shipment.getLightVanProducts(),contains(window));
		assertThat(shipment.getHeavyVanProducts(),contains(floorPanel,door));
	}

}
