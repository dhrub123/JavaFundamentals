package com.dhruba.java.concurrency.threading;

public class RaceCondition {

	public static void main(String[] args) throws InterruptedException {

		LongWrapper longWrapper = new LongWrapper(0L);
		Runnable runnable = () -> {
			for (int i = 0; i < 1_000; i++) {
				longWrapper.incrementValue();
			}
		};
		//If longWrapper increment() is not synchronized , a race condition will happen
		Thread[] threads = new Thread[1000];
		for(int i=0; i<threads.length; i++) {
			threads[i] = new Thread(runnable);
			threads[i].start();
		}
		
		/*Thread thread1 = new Thread(runnable);
		thread1.start();*/
		for(int i=0; i<threads.length; i++) {
			threads[i].join();// This will make sure that code after
						// this is execute once thread1 has finished executing runnable
		}

		System.out.println("Value = " + longWrapper.getL());
	}
}
