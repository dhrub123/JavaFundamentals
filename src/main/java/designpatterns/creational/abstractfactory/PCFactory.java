package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.model.Computer;
import designpatterns.creational.abstractfactory.model.PC;

public class PCFactory implements AbstractComputerFactory {
	
	private String ram;
	private String cpu;
	private String hdd;
	
	public PCFactory(String ram, String cpu, String hdd) {
		this.ram = ram;
		this.cpu = cpu;
		this.hdd = hdd;
	}

	public Computer createComputer() {
		return new PC(ram, cpu, hdd);
	}

}
