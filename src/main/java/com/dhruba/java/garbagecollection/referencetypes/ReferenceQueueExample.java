package com.dhruba.java.garbagecollection.referencetypes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReferenceQueueExample {
	
	public static void main(String[] args) {
		RQPerson p = new RQPerson();
		ReferenceQueue<RQPerson> refQ = new ReferenceQueue<RQPerson>();
		PersonCleaner cleaner = new PersonCleaner();
		PersonWeakReference weakReference = new PersonWeakReference(p, cleaner, refQ);
		System.out.println(weakReference);
		
		p=null;
		System.gc();
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Runnable() {
			
			@Override
			public void run() {
				try {
					PersonWeakReference wr = (PersonWeakReference) refQ.remove();
					System.out.println(wr);
					wr.clean();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press any key to continue");
			br.readLine();
			service.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*try {
			PersonWeakReference wr = (PersonWeakReference) refQ.remove();
			wr.clean();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}

final class RQPerson{
	
}

class PersonCleaner {

	public void clean() {
		System.out.println("Cleaned");
	}
}

class PersonWeakReference extends WeakReference<RQPerson> {

	PersonCleaner cleaner;

	public PersonWeakReference(
			RQPerson referent, 
			PersonCleaner cleaner, 
			ReferenceQueue<? super RQPerson> q){
		super(referent,q);
		this.cleaner = cleaner;
	}
	
	public void clean() {
		cleaner.clean();
	}

}


