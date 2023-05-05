package seven.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindOperationsDemo {

	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23,"India"));
        list.add(new Person("Joe", 18,"USA"));
        list.add(new Person("Ryan", 54,"Canada"));
        list.add(new Person("Iyan", 5,"India"));
        list.add(new Person("Ray", 63,"China"));
        
        //these are terminal operations
        //findfirst - returns an optional describing first element of stream or empty optional if stream is empty
        Optional<Person> firstIndian = list.stream().filter(p -> p.getCountry().equals("India")).findFirst();
        firstIndian.ifPresent(System.out::println);
        //findany - returns an optional describing some element of stream or empty optional if stream is empty
        //useful for parallel streams
        firstIndian = list.stream().filter(p -> p.getCountry().equals("India")).findAny();
        firstIndian.ifPresent(System.out::println);

	}

}
