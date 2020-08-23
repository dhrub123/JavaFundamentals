package designpatterns.creational.builder;

public class BuilderExecutor {
	
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("500 Gigs","Intel i7").build();
		System.out.println(computer);
		
		computer = new Computer.ComputerBuilder("500 Gigs", "Intel i7")
				.setGraphicsCardPresent(true).setWifiEnabled(true).build();
		System.out.println(computer);
	}
}
