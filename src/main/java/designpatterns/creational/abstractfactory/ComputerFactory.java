package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.model.Computer;

public class ComputerFactory {
	
	public static Computer getComputer(AbstractComputerFactory factory) {
		return factory.createComputer();
	}

}
