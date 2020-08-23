package designpatterns.structural.decorator.toppings;
/**
 * concrete decorators decorating interface
 * They extend decorator abstract class
 */
import designpatterns.structural.decorator.Pizza;
import designpatterns.structural.decorator.ToppingsDecorator;

public class Chicken extends ToppingsDecorator {
	
	Pizza pizza;
	
	public Chicken(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public int getCost() {
		return 70 + pizza.getCost();
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + " Chicken";
	}

}
