package designpatterns.creational.prototype;

public class PrototypeExecutor {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData();
		Employees emps1 = (Employees)emps.clone();
		Employees emps2 = (Employees)emps.clone();
		
		System.out.println(emps);
		System.out.println(emps1);
		System.out.println(emps2);
	}

}
