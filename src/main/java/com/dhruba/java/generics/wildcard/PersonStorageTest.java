package com.dhruba.java.generics.wildcard;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonStorageTest {
	
	private Partner don = new Partner(89, "Don Quixote");
	private Partner beth = new Partner(100, "Beth Stone");
	private Employee peggy = new Employee(60, "Peggy Olson");
	
	private File file;
	private PersonSaver saver;
	private PersonLoader loader;
	
	@Test
	public void savesAndLoadsPerson() throws Exception{
		Person person = new Person(20,"Bob");
		saver.save(person);
		assertEquals(person, loader.load());
	}
	
	@Test
	public void savesAndLoadsSpecificPerson() throws Exception{
		saver.save(don);
		assertEquals(don, loader.load());
	}
	
	@Test
	public void savesAndLoadsListOfPeople() throws Exception{
		List<Person> persons = new ArrayList<>();
		persons.add(don);
		persons.add(beth);
		saver.saveAll(persons);
		
		assertEquals(don, loader.load());
		assertEquals(beth, loader.load());
	}
	
	@Test
	public void loadsListsOfPeople() throws Exception{
		saver.save(don);
		saver.save(beth);
		
		List<Object> people = new ArrayList<>();
		loader.loadAll(people);
		
		assertEquals(don, people.get(0));
		assertEquals(beth, people.get(1));
	}
	
	/**
	 Arrays are covariants, they can store person, partner 
	 or employee
	 and we can save them using saver.saveAll()
	 
	 But Lists are not covariants, they can store person, partner 
	 or employee
	 and we cannot save them using saver.saveAll(). They have to be
	 of one type
	 */
	@Before
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @After
    public void tearDown()
    {
        if (file.exists())
        {
            file.delete();
        }
    }
	
}
