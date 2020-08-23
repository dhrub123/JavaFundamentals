package designpatterns.creational.factory;

public class PersonalComputer extends Computer {

	private String ram;
	private String hdd;
	private String cpu;

	public PersonalComputer(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
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
		return "PersonalComputer [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + "]";
	}


}
