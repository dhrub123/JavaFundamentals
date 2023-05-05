package four.collections.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ArrayListIteration {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		numbers.add(60);
		numbers.add(70);
		numbers.add(80);
		numbers.add(90);
		numbers.add(100);

		// for loop
		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i));
		}

		System.out.println();
		System.out.println("*******************");

		// enhanced loop
		for (int i : numbers) {
			System.out.print(i);
		}

		System.out.println();
		System.out.println("*******************");

		// iterators - next and has next
		Iterator<Integer> numberIterator = numbers.iterator();
		while (numberIterator.hasNext()) {
			System.out.print(numberIterator.next());
		}

		System.out.println();
		System.out.println("*******************");

		// iterator --> for each remaining
		numberIterator = numbers.iterator();
		numberIterator.forEachRemaining((e) -> System.out.print(e));

		/*
		 * When we iterate a list, we must use iterator.remove. if we do list.remove we
		 * will get concurrent modification exception Similarly if an element is added
		 * to arraylist after iterator is created, we will also get
		 * concurrentmodification exception
		 */

		System.out.println();
		System.out.println("*******************");
		numberIterator = numbers.iterator();
		/*
		 * below lines will result in concurrent modification exception
		 * numbers.add(110); numberIterator.forEachRemaining((e) ->
		 * System.out.print(e));
		 */

		/* below lines will result in concurrent modification exception */
		while (numberIterator.hasNext()) {
			int next = numberIterator.next();
			if (next == 100) {
				/*
				 * numbers.remove(new Integer(100)); --> this will result in concurrent
				 * modification exception
				 */
				numberIterator.remove();
			}

		}
		System.out.println(numbers);

		/*
		 * Iterators have limitations. They can only iterate in forward direction and no
		 * elements can be updated or inserted in the list during iteration So we can
		 * use ListIterator
		 */

		ListIterator<Integer> numberListIterator = numbers.listIterator();

		System.out.println();
		System.out.println("*******************");

		// forward iteration
		// iterators - next and has next
		while (numberListIterator.hasNext()) {
			System.out.print(numberListIterator.next() + " " + numberListIterator.nextIndex() + " ");
		}

		System.out.println();
		System.out.println("*******************");
		// backward iteration
		// iterators - previous and has previous
		while (numberListIterator.hasPrevious()) {
			System.out.print(numberListIterator.previous() + " " + numberListIterator.previousIndex() + " ");
		}

    System.out.println();
		System.out.println("*******************");
		numbers.forEach(System.out::print);
    
    System.out.println();
		System.out.println("*******************");
		// find numbers greater than 50
		List<Integer> filteredList = numbers.stream().filter(e -> e.intValue() > 50).collect(Collectors.toList());
		System.out.println(filteredList);

	}
}