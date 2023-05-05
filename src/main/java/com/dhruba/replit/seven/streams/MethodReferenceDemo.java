package seven.streams;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceDemo {
	
	public static int getLength(String str) {
		return str.length();
	}
	
	public int getNonStaticLength(String str) {
		return str.length();
	}
	
	public static void main(String[] args) {
		//STATIC METHODS
		//--------------
		List<String> list = new ArrayList<>();
        list.add("done");
        list.add("word");
        list.add("practice");
        list.add("fake");
        
        //without method reference
        list.stream()
        	.mapToInt(str -> MethodReferenceDemo.getLength(str))
        	.forEach(l -> System.out.println(l));
        	
    	//with method reference
        list.stream()
        	.mapToInt(MethodReferenceDemo::getLength)
        	.forEach(System.out::println);
        
        
		//OBJECTS
        MethodReferenceDemo demo = new MethodReferenceDemo();
        list.stream()
    	.mapToInt(demo::getNonStaticLength)
    	.forEach(System.out::println);
        
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alex",23));persons.add(new Person("Xela",32));
		persons.add(new Person("Dhruba",36));persons.add(new Person("Aburhd",63));
		
		int totalAgeOfPersons = persons.stream().mapToInt(Person::getAge).sum();
		System.out.println(totalAgeOfPersons);
		
		//CONSTRUCTORS
		List<String> plist = new ArrayList<>();
		plist.add("Dave");
		plist.add("Joe");
		plist.add("Ryan");
		plist.add("Iyan");
		plist.add("Ray");
        plist.stream().map(Person::new).forEach(System.out::println);
	}
}
