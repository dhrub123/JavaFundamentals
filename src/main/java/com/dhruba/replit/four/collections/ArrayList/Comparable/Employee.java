package four.collections.ArrayList.Comparable;

public class Employee implements Comparable<Employee> {

	/**
	 * A major drawback of comparable is that the comparison logic
	 * gets fixed, we cannot change the attribute to sort on later
	 * For example here sort by age is fixed , we cannot change to 
	 * sort by employeeName
	 */
	private int age;
	private String employeeName;

	public Employee(int age, String employeeName) {
		super();
		this.age = age;
		this.employeeName = employeeName;
	}

	public int compareTo(Employee employee) {
		return this.age - employee.age;
		/*
		 * for string comparison return
		 * this.employeeName.compareTo(employee.getEmployeeName());
		 */
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", employeeName=" + employeeName + "]";
	}

}