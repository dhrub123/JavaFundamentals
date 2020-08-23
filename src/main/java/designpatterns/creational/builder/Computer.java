package designpatterns.creational.builder;

public class Computer {
	
	private String hdd;
	private String cpu;
	private boolean isGraphicsCardPresent;
	private boolean isWifiEnabled;
	
	public String getHdd() {
		return hdd;
	}
	
	public String getCpu() {
		return cpu;
	}
	
	public boolean isGraphicsCardPresent() {
		return isGraphicsCardPresent;
	}
	
	public boolean isWifiEnabled() {
		return isWifiEnabled;
	}
	
	private Computer(ComputerBuilder builder) {
		this.hdd = builder.hdd;
		this.cpu = builder.cpu;
		this.isGraphicsCardPresent = builder.isGraphicsCardPresent;
		this.isWifiEnabled = builder.isWifiEnabled;
	}


	public static class ComputerBuilder{
		
		//Mandatory Fields set through constructor
		private String hdd;
		private String cpu;
		//Constructor of Builder sets these fields		
		public ComputerBuilder(String hdd, String cpu) {
			this.hdd = hdd;
			this.cpu = cpu;
		}
		
		//Optional Fields set through setter
		private boolean isGraphicsCardPresent;
		private boolean isWifiEnabled;
		//setter method sets these fields and returns an instance of builder object
		public ComputerBuilder setGraphicsCardPresent(boolean isGraphicsCardPresent) {
			this.isGraphicsCardPresent = isGraphicsCardPresent;
			return this;
		}
		
		public ComputerBuilder setWifiEnabled(boolean isWifiEnabled) {
			this.isWifiEnabled = isWifiEnabled;
			return this;
		}
		//THe build method builds a new computer using the private constructor
		//and passing a builder instance
		public Computer build() {
			return new Computer(this);
		}
	}


	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", cpu=" + cpu + ", isGraphicsCardPresent=" + isGraphicsCardPresent
				+ ", isWifiEnabled=" + isWifiEnabled + "]";
	}
	
	
}
