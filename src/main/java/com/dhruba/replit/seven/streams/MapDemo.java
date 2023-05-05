package seven.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapDemo {

	public static void main(String[] args) {
		
		//map()
		List<String> strList = new ArrayList<String>();
		strList.add("Alex");strList.add("Bob");strList.add("Caren");strList.add("Dan");
		strList.stream()
			   .map(name -> name.toUpperCase())
			   .forEach(name -> System.out.println(name));
		
		//mapToInt()
		strList.stream()
			   .mapToInt(name -> name.length())
			   .forEach(length -> System.out.println(length));
		
		//flatmap()
		List<List<String>> listOfStringLists = new ArrayList<>();
		listOfStringLists.add(Arrays.asList("a","b","c"));
		listOfStringLists.add(Arrays.asList("d","e","f"));
		listOfStringLists.add(Arrays.asList("g","h","i"));
		listOfStringLists.add(Arrays.asList("j","k","l"));
		
		listOfStringLists.stream()
						.filter(x -> "a".equals(x.toString()))
						.forEach(x -> System.out.println(x)); //will not print anything
		
		listOfStringLists.stream().flatMap(a -> a.stream())
		.filter(x -> "a".equals(x))
		.forEach(x -> System.out.println(x));
	}

}
