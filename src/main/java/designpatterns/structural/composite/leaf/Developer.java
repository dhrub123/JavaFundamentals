package designpatterns.structural.composite.leaf;

import designpatterns.structural.composite.basecomponent.Employee;

/**
 * Represents leaf objects
 * and their behavior
 * Leaf objects do not 
 * have anything below them
 */
public class Developer implements Employee{
	
	private String employeeId;
	private String name;
	private String position;
	
	
	public Developer(String employeeId, String name, String position) {
		this.employeeId = employeeId;
		this.name = name;
		this.position = position;
	}

	public void showEmployeeDetails() {
		System.out.println("employeeId=" + employeeId + ", name=" + name + ", position=" + position); 
	}

}
