package designpatterns.creational.factory;

public class Application {

	public static void main(String[] args) {
		System.out.println(ComputerFactory.getComputer("SERVER", "240 GIGS", "100 TB", "INTEL XEON").toString());
		System.out.println(ComputerFactory.getComputer("PC", "2 GIGS", "1 TB", "AMD THREADRIPPER").toString());
		System.out.println(ComputerFactory.getComputer("MAC", "2 GIGS", "1 TB", "INTEL I7").toString());
	}

}
