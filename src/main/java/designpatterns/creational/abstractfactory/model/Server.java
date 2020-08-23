package designpatterns.creational.abstractfactory.model;

public class Server extends Computer {
	
	private String ram;
	private String cpu;
	private String hdd;
	
	
	public Server(String ram, String cpu, String hdd) {
		this.ram = ram;
		this.cpu = cpu;
		this.hdd = hdd;
	}

	@Override
	public String getRam() {
		return this.ram;
	}

	@Override
	public String getHdd() {
		return this.hdd;
	}

	@Override
	public String getCpu() {
		return this.cpu;
	}

	@Override
	public String toString() {
		return "Server [ram=" + ram + ", cpu=" + cpu + ", hdd=" + hdd + "]";
	}
	
	

}
