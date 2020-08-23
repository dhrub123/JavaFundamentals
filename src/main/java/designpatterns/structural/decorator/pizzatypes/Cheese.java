package designpatterns.structural.decorator.pizzatypes;

import designpatterns.structural.decorator.Pizza;
/**
 * These are different object types
 * implementing base interface
 */
public class Cheese implements Pizza {
	
	
	public String getDescription() {
		return "Cheese";
	}
	
	public int getCost() {
		return 50;
	}

}
