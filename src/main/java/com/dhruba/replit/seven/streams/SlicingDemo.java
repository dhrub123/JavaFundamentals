package seven.streams;

import java.util.ArrayList;
import java.util.List;

public class SlicingDemo {

	public static void main(String[] args) {
		
		List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("China");
        countries.add("India");
        countries.add("UK");
        countries.add("China");
        
        //all of these are intermediate operations
        //distinct
        countries.stream().distinct().forEach(System.out::println);
        //limit
        countries.stream().distinct().limit(3).forEach(System.out::println);
        //skip
        countries.stream().distinct().skip(2).forEach(System.out::println);
	}

}
