package com.dhruba.inputoutput.object.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person2 implements Serializable{
	
	private static final long serialVersionUID = -8554924762611915624L;
	//we can make the following fields transient as well when we use 
	//writeObject
	private String name; 
	private int age;

	public Person2(String name, int age) {
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
	
	//This method is for 2nd type of serialization
	private void writeObject(ObjectOutputStream oos) throws Exception{
		DataOutputStream dos = new DataOutputStream(oos);
		dos.writeUTF(name +  "::" + age);
	}
	
	private void readObject(ObjectInputStream ois) throws Exception{
		DataInputStream dis = new DataInputStream(ois);
		String[] content = dis.readUTF().split("::");
		this.name = content[0];
		this.age = Integer.parseInt(content[1]);
		
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
