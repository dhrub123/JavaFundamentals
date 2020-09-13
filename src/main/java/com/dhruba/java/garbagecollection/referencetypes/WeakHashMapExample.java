package com.dhruba.java.garbagecollection.referencetypes;

import java.util.Date;
import java.util.WeakHashMap;

public class WeakHashMapExample {

	public static void main(String[] args) {

		SpecialPerson dhruba = new SpecialPerson();
		WeakHashMap<SpecialPerson, PersonMetadata> weakHashMap = new WeakHashMap<SpecialPerson, PersonMetadata>();

		weakHashMap.put(dhruba, new PersonMetadata());
		PersonMetadata dhrubaAdditionalInformation = weakHashMap.get(dhruba);
		System.out.println(dhrubaAdditionalInformation);

		dhruba = null;
		System.gc();

		if (weakHashMap.containsValue(dhrubaAdditionalInformation)) {
			System.out.println("Information about Dhruba still present");
		} else {
			System.out.println("No Information");
		}
	}
}

final class SpecialPerson {

}

class PersonMetadata {

	private Date date;

	public PersonMetadata() {
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "PersonMetadata [date=" + date + "]";
	}

}