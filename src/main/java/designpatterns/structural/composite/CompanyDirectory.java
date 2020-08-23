package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

import designpatterns.structural.composite.basecomponent.Employee;
/**
 * This is the composite object
 * which stores all child components(different employees 
 * like developer and Manager)
 * and performs all child related operations(add,remove,clear,show)
 */
public class CompanyDirectory implements Employee{
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public void removeEmployee(Employee employee) {
		employees.remove(employee);
	}
	
	public void deleteAllEmployee() {
		employees.clear();
	}

	public void showEmployeeDetails() {
		for(Employee employee : this.employees) {
			employee.showEmployeeDetails();
		}
	}

}
