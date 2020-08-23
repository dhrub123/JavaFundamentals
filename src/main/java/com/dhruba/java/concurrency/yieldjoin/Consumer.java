package com.dhruba.java.concurrency.yieldjoin;

public class Consumer extends Thread {
	
	public void run() {
		for(int i = 0; i< 5;i++) {
			System.out.println("Consumer " + i);
			Thread.yield();
		}
	}
}
