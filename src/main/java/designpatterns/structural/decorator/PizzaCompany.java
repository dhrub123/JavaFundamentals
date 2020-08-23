package designpatterns.structural.decorator;

import designpatterns.structural.decorator.pizzatypes.BrooklynStyle;
import designpatterns.structural.decorator.pizzatypes.Cheese;
import designpatterns.structural.decorator.toppings.FreshTomato;
import designpatterns.structural.decorator.toppings.Jalapeno;

public class PizzaCompany {
	
	public static void main(String[] args) {
		Pizza pizza = new Cheese();
		FreshTomato tomato = new FreshTomato(pizza);
		System.out.println("Description = " + tomato.getDescription() + " Cost = " + tomato.getCost());
		//Brooklyn Style is a pizza implementation.
		//We keep on decorating it with Fresh Tomato and then Jalapeno, thus adding their features
		Pizza brooklynPizza = new Jalapeno(new FreshTomato(new BrooklynStyle()));
		System.out.println("Description = " + brooklynPizza.getDescription() + " Cost = " + brooklynPizza.getCost());
		
	}

}
