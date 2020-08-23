package designpatterns.creational.abstractfactory;

public class Application {
	public static void main(String[] args) {
		
		System.out.println(ComputerFactory.getComputer(new PCFactory("2 gb", "i7", "2 TB")));
		System.out.println(ComputerFactory.getComputer(new ServerFactory("4 gb", "Xeon", "200 TB")));
		
	}
}
