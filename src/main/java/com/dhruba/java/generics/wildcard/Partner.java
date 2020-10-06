package com.dhruba.java.generics.wildcard;

public class Partner extends Person {

	public Partner(int age, String name) {
		super(age, name);
	}

	@Override
	public String toString() {
		return "Partner [getAge()=" + getAge() + ", getName()=" + getName() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}
	
	

}
