package designpatterns.creational.factory;

//The factory class can be singleton or the factory method can be static
public class ComputerFactory {
	
	public static Computer getComputer(String type, String ram, String hdd, String cpu) {
		if(type.equalsIgnoreCase("SERVER")) return new Server(ram, hdd, cpu);
		else if(type.equalsIgnoreCase("PC")) return new PersonalComputer(ram, hdd, cpu)	;
		return null;
	}

}
