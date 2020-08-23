package com.dhruba.java.collection.set;

public class Student implements Comparable<Student>{
	
	private int id;
	private String name;
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int compareTo(Student o) {
		if(this.id > o.getId()) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
}
