package four.collections.ArrayList.Comparator;

import java.util.Comparator;

public class BrandComparator implements Comparator<Vehicle>{

	public int compare(Vehicle o1, Vehicle o2) {
		return o1.getBrand().compareTo(o2.getBrand());
	}

}