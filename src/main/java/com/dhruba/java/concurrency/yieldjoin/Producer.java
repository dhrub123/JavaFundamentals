package com.dhruba.java.concurrency.yieldjoin;

public class Producer extends Thread {
	
		public void run() {
			for(int i = 0; i< 5;i++) {
				System.out.println("Producer " + i);
				Thread.yield();
			}
		}
}
