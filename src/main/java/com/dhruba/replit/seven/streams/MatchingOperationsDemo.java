package seven.streams;

import java.util.ArrayList;
import java.util.List;

public class MatchingOperationsDemo {
	
	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"Canada"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));
        
        //all matching operations are terminal
        //anymatch() - true(at least one match), false(no match), false(empty stream)
        System.out.println("Canadian Citizen Present = " + list.stream().anyMatch(p -> p.getCountry().equals("Canada")));
        //allmatch() - true(all elements match), false(if even a single element does not match), true(empty stream)
        System.out.println("All are Canadian = " + list.stream().allMatch(p -> p.getCountry().equals("Canada")));
        //nonematch() - true(if no elements match), false(if even a single element matches), true(empty stream)
        System.out.println("No Canadian Present = " + list.stream().noneMatch(p -> p.getCountry().equals("Canada")));
        System.out.println("No Russian Present = " + list.stream().noneMatch(p -> p.getCountry().equals("Russia")));
	}

}
