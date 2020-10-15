package com.dhruba.inputoutput.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.dhruba.inputoutput.object.model.ProxyPerson;

public class WritingDataObjects {

	public static void main(String[] args) {
		
		/* Default Serialization Mechanism - Method 1
		 String fileName = "src/main/resources/person.bin";
		File file = new File(fileName);

		Person p1 = new Person("Linda", 32);
		Person p2 = new Person("David", 27);
		
		List<Person> people = new ArrayList<>();
		people.add(p1);people.add(p2);
		

		try (
				OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os);
		) {
			
			//oos.writeObject(p1);
			//oos.writeObject(p2);
			oos.writeObject(people);
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		try {
			System.out.println("person.bin : " + Files.size(Paths.get(fileName)));
		} catch (IOException ie) {
			ie.printStackTrace();
		} */
		
		/*Default Serialization Mechanism - Method 2
		String fileName = "src/main/resources/person-write-object.bin";
		File file = new File(fileName);

		Person2 p1 = new Person2("Linda", 32);
		Person2 p2 = new Person2("David", 27);
		
		List<Person2> people = new ArrayList<>();
		people.add(p1);people.add(p2);
		

		try (
				OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os);
		) {
			
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(people);
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		try {
			System.out.println("person-write-object.bin : " + Files.size(Paths.get(fileName)));
		} catch (IOException ie) {
			ie.printStackTrace();
		}*/
		
		/*Externizable Method
		String fileName = "src/main/resources/person-write-object-externizable.bin";
		File file = new File(fileName);

		ExternizablePerson p1 = new ExternizablePerson("Linda", 32);
		ExternizablePerson p2 = new ExternizablePerson("David", 27);
		
		List<ExternizablePerson> people = new ArrayList<>();
		people.add(p1);people.add(p2);
		

		try (
				OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os);
		) {
			
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(people);
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		try {
			System.out.println("person-write-object-externizable.bin : " + Files.size(Paths.get(fileName)));
		} catch (IOException ie) {
			ie.printStackTrace();
		}*/
		
		//Proxy Method
		String fileName = "src/main/resources/person-write-object-proxy.bin";
		File file = new File(fileName);

		ProxyPerson p1 = new ProxyPerson("Linda", 32);
		ProxyPerson p2 = new ProxyPerson("David", 27);
		
		List<ProxyPerson> people = new ArrayList<>();
		people.add(p1);people.add(p2);
		

		try (
				OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os);
		) {
			
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(people);
			
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		
		try {
			System.out.println("person-write-object-proxy.bin : " + Files.size(Paths.get(fileName)));
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}

}
