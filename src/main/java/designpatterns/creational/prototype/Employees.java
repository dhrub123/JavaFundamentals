package designpatterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

	private List<String> employees;

	public Employees(List<String> employees) {
		this.employees = employees;
	}
	
	public Employees() {
		this.employees = new ArrayList<String>();
	}

	public List<String> getEmployees() {
		return employees;
	}

	public void setEmployees(List<String> employees) {
		this.employees = employees;
	}
	
	public void loadData() {
		employees.add("Dayita");
		employees.add("Dhruba");
		employees.add("Bhooshan");
		employees.add("Mohan");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		List<String> copiedEmployees = new ArrayList<String>();
		for(String employee : employees) {
			copiedEmployees.add(employee);
		}
		return copiedEmployees;
	}

	@Override
	public String toString() {
		return "Employees [employees=" + employees + "]";
	}
	
}
