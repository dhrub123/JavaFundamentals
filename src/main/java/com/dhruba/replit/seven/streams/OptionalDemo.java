package seven.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
	
	Map<String, Person> personMap = new HashMap<>();
	
	public Optional<Person> getPerson(String name){
		return Optional.ofNullable(personMap.get(name));
	}
	
	public void populateMapWithPerson(){
		this.personMap.put("alex", new Person("Alex",23));
	}
	
	public Person getDefaultPerson(){
		return new Person("Tom",23);
	}
	
	public static void main(String[] args) {
		OptionalDemo demo = new OptionalDemo();
		//demo.populateMapWithPerson(); 
		Optional<Person> alex = demo.getPerson("alex");
		System.out.println(alex.orElse(demo.getDefaultPerson()));//if alex has value , alex is printed else tom is printed
		if(alex.isPresent()) {
		 System.out.println(alex.get());
		}else {
		 System.out.println("Alex is absent");
		}
		 
		//ifPresent() -- if value is present , consumer invoked else nothing happens
		demo.populateMapWithPerson();
		alex = demo.getPerson("alex");
		alex.ifPresent(System.out::println);
		
		//orElseGet(Supplier<? extends T> other) - if no value present, default value calculated from the supplier provided 
		//as parameter
		Optional<Person> optional = Optional.ofNullable(null);
        System.out.println(optional.orElseGet(demo::getDefaultPerson));
        //orElseThrow(Supplier<? extends T> other) - if no value present exception created by provided supplier thrown
        optional = Optional.ofNullable(null);
        try {
            System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //filter() - Optional<T> filter(Predicate<? super T> predicate)
        optional = Optional.ofNullable(demo.getDefaultPerson());
        System.out.println(optional.filter(p -> p.getName().equals("Tom")));
        System.out.println(optional.filter(p -> p.getName().equals("Alex")));
        
        //map - map(Function<? super T, ? extends U> mapper)
        optional = Optional.ofNullable(demo.getDefaultPerson());
        optional.map(p -> p.getAge())
        		.filter(age -> age > 18)
        		.ifPresent(System.out::println);
        //flatmap - flatMap(Function<? super T, Optional<U>> mapper)
        //a getter returning optional is needed in pojo
        optional.flatMap(person -> person.getOptionalAge())
                .filter(age -> age > 18)
                .ifPresent(System.out::println);
	}

}
