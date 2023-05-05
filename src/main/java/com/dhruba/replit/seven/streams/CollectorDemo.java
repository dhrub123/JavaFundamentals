package seven.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Alex", 23, 23000, "USA"));
		employeeList.add(new Employee("Ben", 63, 25000, "India"));
		employeeList.add(new Employee("Dave", 34, 56000, "India"));
		employeeList.add(new Employee("Jodi", 43, 67000, "China"));
		employeeList.add(new Employee("Ryan", 53, 54000, "USA"));
		employeeList.add(new Employee("Don", 53, 54000, "USA"));

		// toList
		List<String> employeeNames = employeeList
				.stream()
				.map(e -> e.getName())
				.collect(Collectors.toList());
		System.out.println("Name of employees = " + employeeNames);
		
		//toSet
		Set<String> emplyeeNamesInASet = employeeList
				.stream()
				.map(e -> e.getName())
				.collect(Collectors.toSet());
		
		System.out.println("Name of employees = " + emplyeeNamesInASet);
		
		//toCollection
		LinkedList<String> emplyeeNamesInALinkedList = employeeList
				.stream()
				.map(e -> e.getName())
				.collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println("Name of employees = " + emplyeeNamesInALinkedList);
		
		//toMap
		Map<String,Integer> employeeAgeMap = employeeList
				.stream()
				.collect(Collectors.toMap(e -> e.getName(), e -> e.getAge()));
		
		System.out.println("Employee map = " + employeeAgeMap);
		
		//in case of duplicates
		employeeAgeMap = employeeList
				.stream()
				.collect(Collectors.toMap(e -> e.getName(), e -> e.getAge(), (e1,e2)-> e1));
		
		System.out.println("Employee map = " + employeeAgeMap);
		
		//use specific maps like a treemap
		employeeAgeMap = employeeList
				.stream()
				.collect(Collectors.toMap(e -> e.getName(), e -> e.getAge(), (e1,e2)-> e1, TreeMap::new));
		
		System.out.println("Employee map = " + employeeAgeMap);
		
		//collecting and then
		employeeNames = employeeList
				.stream()
				.map(e -> e.getName())
				.collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
				
		System.out.println("Name of employees = " + employeeNames);	
		
		//aggregation ops
		//----------------------------------------------------
		//counting
		long count = employeeList
						.stream()
						.filter(e -> e.getAge()>30)
						.collect(Collectors.counting());
		System.out.println("Count of employees whose age is greater than 30 = " + count);
		
		//summingint
		long sumOfSalaries = employeeList
								.stream()
								.collect(Collectors.summingInt(e -> e.getSalary()));
								
		System.out.println("Sum of salaries of all employees = " + sumOfSalaries);
		
		//averagingint
		double averageOfSalaries = employeeList
				.stream()
				.collect(Collectors.averagingInt(e -> e.getSalary()));
				
		System.out.println("Average of salaries of all employees = " + averageOfSalaries);
		
		//minby --> find employee with minimum salary
		
		Optional<Employee> employeeWithMinimumSalary = 
				employeeList
				.stream()
				.collect(Collectors.minBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("Employee with minimum salary = " + employeeWithMinimumSalary.get());
		
		//maxBy --> find employee with maximum salary
		
		Optional<Employee> employeeWithMaximumSalary = 
				employeeList
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("Employee with maximum salary = " + employeeWithMaximumSalary.get());
		
		//summarizingint --> results in IntSummaryStatistics{count=3, sum=6, min=1, average=2.000000, max=3}
		IntSummaryStatistics summarizingInt = Stream.of("1", "2", "3").collect(Collectors.summarizingInt(Integer::parseInt));
        System.out.println(summarizingInt);
        
        //joining - joins streams in encounter order
        String joinedString = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining());
        System.out.println(joinedString);
        
        String joinedStringWithSpace = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining(" "));
        System.out.println(joinedStringWithSpace);
        
        String joinedStringWithPrefixAndSuffix = Stream.of("hello", "how", "are" , "you")
                .collect(Collectors.joining(" ","prefix "," suffix"));
        System.out.println(joinedStringWithPrefixAndSuffix);
        
        //grouping operations
        //----------------------------------------------------
        //groupingBy
        //----------------------------------------------------
        Map<String,List<Employee>> employeeGroupedByCountry = employeeList
		.stream().collect(Collectors.groupingBy(Employee::getCountry));
        System.out.println(employeeGroupedByCountry);
        
        //groupingBy(Function<? super T,? extends K> classifier, Collector<? super T,A,D> downstream)
        //----------------------------------------------------
        Map<String,Set<Employee>> employeeGroupedByCountryOrdered = employeeList
        		.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.toSet()));
        System.out.println(employeeGroupedByCountryOrdered);
        
        //groupbymultipleconditions
        Map<String,Map<Integer,List<Employee>>> employeeGroupedByCountryAndAge = employeeList
        		.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.groupingBy(Employee::getAge)));
        System.out.println(employeeGroupedByCountryAndAge);
        
        //key is country and value is sum of all salariesbycountry
        Map<String,Integer> totalSalaryByCountry = employeeList
        		.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.summingInt(Employee::getSalary)));
        System.out.println(totalSalaryByCountry);
        
        //Map where the key is the name of the country and the value is the Employee object that has the max salary 
        //in that country.
        Map<String,Optional<Employee>> mapOfCountryANdEmployeeWithHighestSalary = employeeList
		.stream().collect(Collectors.groupingBy(Employee::getCountry,Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println(mapOfCountryANdEmployeeWithHighestSalary);
        
        //groupingBy(Function<? super T,? extends K> classifier, Supplier<M> mapFactory, Collector<? super T,A,D> downstream)
        //----------------------------------------------------
        Map<String, Set<Employee>> employeeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getCountry, HashMap::new, Collectors.toSet()));
        System.out.println(employeeMap);
        
        //groupingByConcurrent(Function<? super T,? extends K> classifier)
        //----------------------------------------------------
        ConcurrentMap<String,List<Employee>> concurrentEmployeeMap = employeeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getCountry));
        System.out.println(concurrentEmployeeMap);
        
        //partitioningBy --> partition employees with age > 30 and < 30
        //-----------------------------
        Map<Boolean, List<Employee>> employeeMappartitionedByAge 
        		= employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge()>30));
        System.out.println(employeeMappartitionedByAge);
        
        
	}

}
