package four.collections.ArrayList.Comparator;

public class Vehicle {

	private String brand;
	private Integer makeYear;

	public Vehicle(String brand, Integer makeYear) {
		super();
		this.brand = brand;
		this.makeYear = makeYear;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getMakeYear() {
		return makeYear;
	}

	public void setMakeYear(Integer makeYear) {
		this.makeYear = makeYear;
	}

	@Override
	public String toString() {
		return "Vehicle [brand=" + brand + ", makeYear=" + makeYear + "]";
	}

}