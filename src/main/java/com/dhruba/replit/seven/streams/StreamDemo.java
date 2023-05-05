package seven.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {
		Stream<Integer> intStream = Stream.of(1,2,3,4,5,6,7,8,9);
		intStream.forEach(i -> System.out.println(i));
		
		List<String> strList = new ArrayList<String>();
		strList.add("a");strList.add("b");strList.add("c");strList.add("d");
		strList.forEach(s -> System.out.println(s));

	}

}
