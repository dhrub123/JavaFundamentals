package designpatterns.structural.decorator.toppings;

import designpatterns.structural.decorator.Pizza;
import designpatterns.structural.decorator.ToppingsDecorator;
/**
 * concrete decorators decorating interface
 * They extend decorator abstract class
 */
public class FreshTomato extends ToppingsDecorator {
	
	Pizza pizza;
	
	public FreshTomato(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int getCost() {
		return 20 + pizza.getCost();
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " Fresh Tomato";
	}

}
