package com.dhruba.java.generics.wildcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader {

	private final RandomAccessFile file;

	public PersonLoader(final File file) throws FileNotFoundException {
		this.file = new RandomAccessFile(file, "rw");
	}

	public Person load() throws ClassNotFoundException {
		try {
			final String className = file.readUTF();
			final String personName = file.readUTF();
			final int age = file.readInt();
			
			//Unbounded Wildcards, can be person or a partner or an Employee or anything, same as Class<? extends Object>
			final Class<?> personClass = Class.forName(className);
			final Constructor<?> constructor = personClass.getConstructor(int.class, String.class);
			return (Person) constructor.newInstance(age, personName);
		} catch (IOException e) {
			return null;
		} catch (NoSuchMethodException | InvocationTargetException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	//List<? super Person> is an example of lower bounded wildcard -- anything that is a person or a prent of a person
	public void loadAll(final List<? super Person> people) throws ClassNotFoundException {
		Person person;

		while ((person = load()) != null) {
			people.add(person);
		}
	}

}
