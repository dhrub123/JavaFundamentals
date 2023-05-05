package four.collections.HashMap;

import java.util.Map;
import java.util.HashMap;

public class HashMapExample {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 21);
		map.put("B", 29);
		map.put("C", 47);
		System.out.println(map);
		map.replaceAll((k, v) -> v + 10);
		System.out.println(map);

		// ************Java 8 improvements

		/*
		 * compute(K key, BiFunction remappingFunction) - updates value in hashmap for a
		 * specified key or null if key is not present.
		 */
		map.compute("B", (k, v) -> v == null ? 10 : v + 10);
		System.out.println(map);
		map.compute("D", (k, v) -> v == null ? 10 : v + 10);
		System.out.println(map); // does not update anything

		/*
		 * computeIfAbsent(Key, Function) - computes value for key using given function
		 * and enters computed value in hashmap only if key is not present or present
		 * with a null value
		 */

		map.computeIfAbsent("EF", k -> k.length());
		System.out.println(map);

		/*
		 * computeIfPresent(Key, Function) - computes value for key using given function
		 * and updates computed value in hashmap only if key is present and associated
		 * with a non null value
		 */

		map.computeIfPresent("EF", (k, v) -> v == null ? 10 : v + 7);
		System.out.println(map);

		map.computeIfPresent("G", (k, v) -> v == null ? 10 : v + 7);
		System.out.println(map); // inserts nothing since G is not present

		/*
		 * merge - used to merge 2 maps - merge(K key, V value, BiFunction
		 * remappingFunction) key - the key which needs to be merged, value - the value
		 * which needs to be inserted in case key is not present, bifunction which will
		 * compute the new value
		 */
		Map<String, Integer> map1 = new HashMap<>();
		map1.putAll(map);
		map1.replaceAll((k, v) -> v == null ? 12 : v + 4);
		System.out.println("New map to merge to " + map1);

		map.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> v1 + v2));
		System.out.println("Merged Map = " + map1);

	}
}
