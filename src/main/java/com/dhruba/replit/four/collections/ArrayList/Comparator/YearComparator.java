package four.collections.ArrayList.Comparator;

import java.util.Comparator;

public class YearComparator implements Comparator<Vehicle>{

	public int compare(Vehicle o1, Vehicle o2) {
		return o1.getMakeYear().compareTo(o2.getMakeYear());
	}

}