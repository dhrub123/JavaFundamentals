package com.dhruba.java.generics.wildcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaExpressionAndGenerics {
	
	public static void main(String[] args) {
		
		final Person don = new Partner(89, "Don Quixote");
		final Person beth = new Partner(100, "Beth Stone");
		final Person peggy = new Employee(60, "Peggy Olson");
		
		Predicate<Person> isOld =  person -> person.getAge() > 80;
		System.out.println("Don is old ? " + isOld.test(don) + //true
						   " Peggy is old ? " + isOld.test(peggy) + //false
						   " Beth is old ? " + isOld.test(beth) //true
				);
		
		List<Person> people = new ArrayList<>();
		people.add(don);people.add(beth);people.add(peggy);
		
		Map<Boolean, List<Person>> oldAndYoungPeople = 
				people.stream().collect(Collectors.partitioningBy(isOld));
		System.out.println(oldAndYoungPeople);
		//{false=[Employee [getAge()=60, getName()=Peggy Olson, toString()=Person [age=60, name=Peggy Olson], 
		//hashCode()=-1752405058, getClass()=class com.dhruba.java.generics.wildcard.Employee]], 
		
		//true=[Partner [getAge()=89, getName()=Don Quixote, toString()=Person [age=89, name=Don Quixote], 
		//hashCode()=-1264286632, getClass()=class com.dhruba.java.generics.wildcard.Partner], 
		//Partner [getAge()=100, getName()=Beth Stone, toString()=Person [age=100, name=Beth Stone], 
		//hashCode()=1155696857, getClass()=class com.dhruba.java.generics.wildcard.Partner]]}
		
		Map<Boolean, Long> oldandYoungPeopleCounted = people.stream()
				.collect(Collectors.partitioningBy(isOld, Collectors.counting()));
		System.out.println(oldandYoungPeopleCounted); //{false=1, true=2}
	}
}
