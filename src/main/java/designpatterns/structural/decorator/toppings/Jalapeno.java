package designpatterns.structural.decorator.toppings;

import designpatterns.structural.decorator.Pizza;
import designpatterns.structural.decorator.ToppingsDecorator;
/**
 * concrete decorators decorating interface
 * They extend decorator abstract class
 */
public class Jalapeno extends ToppingsDecorator {
	
	Pizza pizza;
	
	public Jalapeno(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int getCost() {
		return 30 + pizza.getCost();
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " Jalapeno";
	}

}
