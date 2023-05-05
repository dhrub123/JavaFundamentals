package four.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionOperations {

	public static void main(String[] args) {

		/*
		 * Finding minimum and maximum element in Collections - min() and max(). The
		 * element in collection must implement Comparable or comparator must be passed
		 * to min(Collection c ,Comparator co) and max(Collection c ,Comparator co)
		 */

		List<Integer> list = new ArrayList<>();
		list.add(34);
		list.add(12);
		list.add(9);
		list.add(76);
		list.add(29);
		list.add(75);
		list.add(9);
		System.out.println("minimum value = " + Collections.min(list));
		System.out.println("maximum value = " + Collections.max(list));

		// frequency - complexity is proportional to size of collection
		System.out.println("frequency of 9 in collection is = " + Collections.frequency(list, 9));

		/*
		 * search a collection - binarySearch(List list, key key) - the elements in list
		 * must implement Comparable and the list must be sorted into ascending order.
		 * If the element does not implement Comparable, we can pass a comparator -
		 * binarySearch(List list, key key, Comparator comp) - if element is not present
		 * in list, a position is returned where element can be inserted
		 */
		Collections.sort(list);
		System.out.println("76 is present in: " + Collections.binarySearch(list, new Integer(76)));

		/*
		 * copy list - copy() - replaces elements in destination list from source list
		 * in case there are different elements
		 */
		List<Integer> destinationList = new ArrayList<>();
		destinationList.add(34);
		destinationList.add(12);
		destinationList.add(9);
		destinationList.add(176);
		destinationList.add(29);
		destinationList.add(275);
		destinationList.add(9);
		Collections.sort(destinationList);
		Collections.copy(list, destinationList);
		System.out.println("Copied List = " + destinationList);

		// Fill list with default value
		List<Integer> defaultFillList = new ArrayList<>();
		defaultFillList.add(34);
		defaultFillList.add(14);
		Collections.fill(defaultFillList, 17);
		System.out.println("Default Fill List = " + defaultFillList);
	}

}
