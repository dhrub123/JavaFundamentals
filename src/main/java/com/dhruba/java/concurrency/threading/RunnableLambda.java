package com.dhruba.java.concurrency.threading;

public class RunnableLambda {
	
	public static void main(String[] args) {
		
		Runnable runnable = () -> System.out.println("Thread running is " + Thread.currentThread().getName());
		
		Thread t = new Thread(runnable);
		t.setName("Worker thread1");
		t.start(); //This will launch in own thread
		//t.run(); //This will launch in main thread
	}
}
