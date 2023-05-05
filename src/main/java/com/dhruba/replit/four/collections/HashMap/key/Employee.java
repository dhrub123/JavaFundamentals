package four.collections.HashMap.key;

/* In this example the Employee object is used as key and salary as value. 
   For an object to be a good key, it should override both hashcode() and equals()
   A key should be designed using immutable properties like wrapper classes - String, 
   Integer etc.
 */
public class Employee {

	private Integer empId;
	private String ename;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Employee(Integer empId, String ename) {
		super();
		this.empId = empId;
		this.ename = ename;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", ename=" + ename + "]";
	}
	
	

}
