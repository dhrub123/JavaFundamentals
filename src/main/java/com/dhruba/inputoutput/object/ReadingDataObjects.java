package com.dhruba.inputoutput.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import com.dhruba.inputoutput.object.model.ProxyPerson;

public class ReadingDataObjects {
	
	public static void main(String[] args) {
		
		/*String fileName = "src/main/resources/person.bin";
		File file = new File(fileName);
		
		try(
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
		){
			@SuppressWarnings("unchecked")
			List<Person> people = (List<Person>)ois.readObject();
			people.forEach(System.out::println);
		}catch(IOException | ClassNotFoundException ie){
			ie.printStackTrace();
		}*/
		
		/*
		String fileName = "src/main/resources/person-write-object.bin";
		File file = new File(fileName);
		
		try(
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
		){
			Person2 p1 = (Person2)ois.readObject();
			System.out.println(p1);
			Person2 p2 = (Person2)ois.readObject();
			System.out.println(p2);
		}catch(IOException | ClassNotFoundException ie){
			ie.printStackTrace();
		}
		*/
		
		/*String fileName = "src/main/resources/person-write-object-externizable.bin";
		File file = new File(fileName);
		
		try(
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
		){
			ExternizablePerson p1 = (ExternizablePerson)ois.readObject();
			System.out.println(p1);
			ExternizablePerson p2 = (ExternizablePerson)ois.readObject();
			System.out.println(p2);
		}catch(IOException | ClassNotFoundException ie){
			ie.printStackTrace();
		}*/
		
		String fileName = "src/main/resources/person-write-object-proxy.bin";
		File file = new File(fileName);
		
		try(
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
		){
			ProxyPerson p1 = (ProxyPerson)ois.readObject();
			System.out.println(p1);
			ProxyPerson p2 = (ProxyPerson)ois.readObject();
			System.out.println(p2);
		}catch(IOException | ClassNotFoundException ie){
			ie.printStackTrace();
		}
		
		
		
	}

}
