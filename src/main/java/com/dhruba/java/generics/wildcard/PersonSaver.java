package com.dhruba.java.generics.wildcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver {

	private final RandomAccessFile file;

	public PersonSaver(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}

	public void save(Person person) throws IOException {
		file.writeUTF(person.getClass().getName());
		file.writeUTF(person.getName());
		file.writeInt(person.getAge());
		
	}
	
	//This is an example of a upper bounded wildcard
	//we could have also written 
	//public <T extends Person> void saveAll(final List<T> persons) 
	public void saveAll(final List<? extends Person> persons) throws IOException {
		for (Person person : persons) {
			save(person);
		}
	}

}
