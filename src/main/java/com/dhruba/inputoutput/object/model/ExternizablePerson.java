package com.dhruba.inputoutput.object.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternizablePerson implements Externalizable{
	
	private static final long serialVersionUID = -8554924762611915624L;
	
	private String name; 
	private int age;

	public ExternizablePerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public ExternizablePerson() {
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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		String pk = name + "::" + age;
		out.write(pk.getBytes());
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		
		byte[] buffer = new byte[1024];
		int read = in.read(buffer);
		String content = new String(buffer, 0, read);
		String[] strings = content.split("::");
		this.name = strings[0];
		this.age = Integer.parseInt(strings[1]);
		
	}

}
