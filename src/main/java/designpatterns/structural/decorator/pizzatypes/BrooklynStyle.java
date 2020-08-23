package designpatterns.structural.decorator.pizzatypes;

import designpatterns.structural.decorator.Pizza;
/**
 * These are different object types
 * implementing base interface
 */
public class BrooklynStyle implements Pizza {
	
	
	public String getDescription() {
		return "BrooklynStyle";
	}
	
	public int getCost() {
		return 80;
	}

}
