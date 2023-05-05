package four.collections.TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapSortingByValue {

	public static void main(String[] args) {

		/*
		 * a treemap is sorted by value of key. But we can also sort a treemap by values
		 * using a comparator
		 */
		TreeMap<String, Integer> stockMap = new TreeMap<>();
		stockMap.put("Oracle", 43);
		stockMap.put("Microsoft", 56);
		stockMap.put("Apple", 76);
		stockMap.put("Novartis", 87);
		stockMap.put("Google", 23);
		stockMap.put("Audi", 101);
		
		System.out.println(sortMapByValues(stockMap));

	}

	public static TreeMap<String, Integer> sortMapByValues(TreeMap<String, Integer> sourceMap) {

		Comparator<String> valueComparator = new Comparator<String>() {

			public int compare(String o1, String o2) {
				int comparisonResult = sourceMap.get(o1).compareTo(sourceMap.get(o2));
				if (comparisonResult == 0) {
					return 1;
				} else {
					return comparisonResult;
				}
			}

		};

		TreeMap<String, Integer> mapSortedByValues = new TreeMap<>(valueComparator);
		mapSortedByValues.putAll(sourceMap);
		
		//Using Java 8
		Comparator<String> valueComparatorJ8 = (o1, o2) -> {

			int comparisonResult = sourceMap.get(o1).compareTo(sourceMap.get(o2));
			if (comparisonResult == 0) {
				return 1;
			} else {
				return comparisonResult;
			}

		};

		mapSortedByValues = new TreeMap<>(valueComparatorJ8);
		mapSortedByValues.putAll(sourceMap);
		
		return mapSortedByValues;
	}
}
