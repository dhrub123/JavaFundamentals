package seven.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		Stream.of(1,2,3,4,5,6,7)
			  .forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
		//here main method is doing all the work
		Stream.of(1,2,3,4,5,6,7)
		  .parallel()
		  .forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
		//here 4 thread are spawned simultaneously and ForkJoinPool is used internally
	
		//Lazy Evaluation example 
		List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);

	    Optional<Integer> number = data.stream()
	                .filter(num -> {
	                    System.out.println("Processing first filter for number " + num);
	                    return num > 5;
	                })
	                .filter(num -> {
	                    System.out.println("Processing second filter for number " + num);
	                    return num % 3 == 0;
	                })
	                .findFirst();
	
        System.out.println(number.get());
	
	}

}
