package seven.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ReductionOperationDemo {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();
        list.add(new Person("Dave", 23));
        list.add(new Person("Joe", 18));
        list.add(new Person("Ryan", 54));
        list.add(new Person("Iyan", 5));
        list.add(new Person("Ray", 63));
        
        //reduce
        Optional<Integer> totalAge = list.stream().map(p -> p.getAge()).reduce((a,b) -> a + b);
        totalAge.ifPresent(System.out::println);
        
        //sum
        int totalAgeValue = list.stream().mapToInt(p -> p.getAge()).sum();
        System.out.println(totalAgeValue);
        
        //reduce(identity, binaryoperator) --> if stream is empty, identity will be returned
        //else 5 will be added to the sum
        totalAgeValue = list.stream().map(p -> p.getAge()).reduce(5,(a,b) -> a + b);
        System.out.println(totalAgeValue);
        
        //reduce(identity,bifunction, binaryopearator) --> for parallel streams
        totalAgeValue = list.parallelStream().map(p -> p.getAge()).reduce(0,(a,b) -> a + b,Integer::sum);
        System.out.println(totalAgeValue);
        
        //max and min
        Optional<Integer> maxAge = list.stream().map(p -> p.getAge()).max(Comparator.naturalOrder());
        maxAge.ifPresent(System.out::println);
        Optional<Integer> minAge = list.stream().map(p -> p.getAge()).min(Comparator.naturalOrder());
        minAge.ifPresent(System.out::println);
	}

}
