package designpatterns.structural.composite;

import designpatterns.structural.composite.basecomponent.Employee;
import designpatterns.structural.composite.leaf.Developer;
import designpatterns.structural.composite.leaf.Manager;

/**
 * The client interacts with composite
 * using component interface to add/remove data
 *
 */
public class Company {
	
	public static void main(String[] args) {
		Employee Dhruba = new Developer("490919", "Dhruba Nag", "Senior Developer");
		Employee Sandeep = new Developer("390919", "Sandeep Kulkarni", "Developer");
		
		Employee Bhooshan = new Manager("326754", "Bhooshan Tappe", "Manager");
		Employee Naga = new Manager("226754", "Naga Rajan", "Senior Manager");
		
		CompanyDirectory techTeamDirectory = new CompanyDirectory();
		techTeamDirectory.addEmployee(Dhruba);
		techTeamDirectory.addEmployee(Sandeep);
		//techTeamDirectory.showEmployeeDetails();
		
		CompanyDirectory managementTeamDirectory = new CompanyDirectory();
		managementTeamDirectory.addEmployee(Bhooshan);
		managementTeamDirectory.addEmployee(Naga);
		//managementTeamDirectory.showEmployeeDetails();
		
		CompanyDirectory directory = new CompanyDirectory();
		directory.addEmployee(techTeamDirectory);
		directory.addEmployee(managementTeamDirectory);
		directory.showEmployeeDetails();
	}
	

}
