package four.collections.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;

public class HashMapIteration {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("IBM", 21);
		map.put("APPLE", 29);
		map.put("GOOGLE", 47);
		map.put("MICORSOFT", 23);
		System.out.println(map);

		// entrySet() returns set view --> Set<Entry<String, Integer>> and for loop
		System.out.println("Using entryset and for loop");
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.println("Company Name = " + entry.getKey() + " Stock Price = " + entry.getValue());
		}

		// entryset and iterator
		System.out.println("Using entryset and iterator");
		Iterator<Entry<String, Integer>> itr = entrySet.iterator();
		while (itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			System.out.println("Company Name = " + entry.getKey() + " Stock Price = " + entry.getValue());
		}

		// Using for each and Biconsumer
		System.out.println("Using foreach and Biconsumer");
		map.forEach((key, value) -> System.out.println("Company Name = " + key + " Stock Price = " + value));
	}

}
