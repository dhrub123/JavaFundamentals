package com.dhruba.inputoutput.object.model;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class ProxyPerson implements Serializable{
	
	private String name; 
	private int age;
	
	private Object writeReplace() throws ObjectStreamException{
		return new PersonProxy(name+"::"+age);
	}
	
	public ProxyPerson() {
	}
	
	public ProxyPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
