package designpatterns.structural.decorator.pizzatypes;

import designpatterns.structural.decorator.Pizza;
/**
 * These are different object types
 * implementing base interface
 */
public class Farmhouse implements Pizza {
	
	
	public String getDescription() {
		return "Farmhouse";
	}
	
	public int getCost() {
		return 40;
	}

}
