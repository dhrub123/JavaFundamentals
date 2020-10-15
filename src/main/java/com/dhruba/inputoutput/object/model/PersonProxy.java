package com.dhruba.inputoutput.object.model;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class PersonProxy implements Serializable {

	private String name;

	public PersonProxy(String name) {
		this.name = name;
	}

	public PersonProxy() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonProxy [name=" + name + "]";
	}

	private Object readResolve() throws ObjectStreamException {

		String[] content = this.name.split("::");
		ProxyPerson p = new ProxyPerson(content[0], Integer.parseInt(content[1]));
		return p;
	}

}
