package four.collections.ArrayList.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {

		List<Vehicle> vehicles = new ArrayList<>();
		vehicles.add(new Vehicle("Hyundai", 2001));
		vehicles.add(new Vehicle("Suzuki", 1998));
		vehicles.add(new Vehicle("Volkswagen", 2000));
		vehicles.add(new Vehicle("HM", 1988));
		vehicles.add(new Vehicle("Mercedes", 2007));
		vehicles.add(new Vehicle("Audi", 2010));
		vehicles.add(new Vehicle("Tesla", 2020));
		System.out.println(vehicles);

		/**
		 * The comparators help us to sort by any attribute We just need to pass
		 * appropriate comparator
		 */

		Collections.sort(vehicles, new BrandComparator());
		System.out.println("Sorted by brand name " + vehicles);
		Collections.sort(vehicles, new YearComparator());
		System.out.println("Sorted by make year " + vehicles);

		//Anonymous class
		Collections.sort(vehicles, new Comparator<Vehicle>() {

			public int compare(Vehicle o1, Vehicle o2) {
				return o1.getMakeYear().compareTo(o2.getMakeYear());
			}
		});
		System.out.println("Sorted by make year " + vehicles);
		
		//lambda Expressions
		Collections.sort(vehicles, (v1,v2) -> v1.getMakeYear().compareTo(v2.getMakeYear()));
		System.out.println("Sorted by make year " + vehicles);
	}

}