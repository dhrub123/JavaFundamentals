package four.collections.Arrays;

public class Employee {

	private int eId;
	private String ename;

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Employee(int eId, String ename) {
		super();
		this.eId = eId;
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", ename=" + ename + "]";
	}

}
