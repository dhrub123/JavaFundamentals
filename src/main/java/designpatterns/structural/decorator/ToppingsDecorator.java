package designpatterns.structural.decorator;
/**
 * decorator class
 */
public abstract class ToppingsDecorator implements Pizza {

	public abstract String getDescription();

	public abstract int getCost();

}
