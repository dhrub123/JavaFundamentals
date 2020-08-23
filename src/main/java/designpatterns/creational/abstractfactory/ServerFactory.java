package designpatterns.creational.abstractfactory;

import designpatterns.creational.abstractfactory.model.Computer;
import designpatterns.creational.abstractfactory.model.Server;

public class ServerFactory implements AbstractComputerFactory {
	
	private String ram;
	private String cpu;
	private String hdd;
	
	public ServerFactory(String ram, String cpu, String hdd) {
		this.ram = ram;
		this.cpu = cpu;
		this.hdd = hdd;
	}

	public Computer createComputer() {
		return new Server(ram, cpu, hdd);
	}

}
