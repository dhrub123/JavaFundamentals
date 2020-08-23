package designpatterns.structural.decorator.toppings;

import designpatterns.structural.decorator.Pizza;
import designpatterns.structural.decorator.ToppingsDecorator;
/**
 * concrete decorators decorating interface
 * They extend decorator abstract class
 */
public class Paneer extends ToppingsDecorator {
	
	Pizza pizza;
	
	public Paneer(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getCost() {
		return 50 + pizza.getCost();
	}

	public String getDescription() {
		return pizza.getDescription() + " Paneer";
	}

}
