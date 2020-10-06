package com.dhruba.java.generics.wildcard;

public class Employee extends Person {

	public Employee(int age, String name) {
		super(age, name);
	}

	@Override
	public String toString() {
		return "Employee [getAge()=" + getAge() + ", getName()=" + getName() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}

}
