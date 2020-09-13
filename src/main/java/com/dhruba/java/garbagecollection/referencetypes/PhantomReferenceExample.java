package com.dhruba.java.garbagecollection.referencetypes;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

public class PhantomReferenceExample {
	
	public static void main(String[] args) {
		
		ReferenceQueue<PhantomPerson> refQ = new ReferenceQueue<PhantomPerson>();
		List<FinalizePerson> finalizepersonList = new ArrayList<FinalizePerson>();
		List<PhantomPerson> phantomPeople = new ArrayList<PhantomPerson>();
		
		for(int i=0; i<10; i++) {
			PhantomPerson phantomPerson = new PhantomPerson();
			phantomPeople.add(phantomPerson);
			finalizepersonList.add(new FinalizePerson(phantomPerson, refQ));
		}
		
		phantomPeople = null;
		System.gc();
		
		finalizepersonList.stream().forEach(finalizePerson -> System.out.println(finalizePerson.isEnqueued()));
		
		//get phantom references
		Reference<? extends PhantomPerson> referenceFromQueue;
		while((referenceFromQueue = refQ.poll()) != null) {
			((FinalizePerson)referenceFromQueue).cleanup();
		}
		
	}
}

class FinalizePerson extends PhantomReference<PhantomPerson>{

	public FinalizePerson(PhantomPerson referent, ReferenceQueue<? super PhantomPerson> q) {
		super(referent, q);
	}
	
	public void cleanup() {
		System.out.println("Person is finalizing resource");
	}
}

class PhantomPerson{
	
}
