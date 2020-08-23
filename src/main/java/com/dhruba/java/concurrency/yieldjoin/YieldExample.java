package com.dhruba.java.concurrency.yieldjoin;

public class YieldExample {
	public static void main(String[] args) {
		Thread producer = new Producer();
		Thread consumer = new Consumer();
		
		producer.setPriority(Thread.MIN_PRIORITY);
		consumer.setPriority(Thread.MIN_PRIORITY);
		
		producer.start();
		consumer.start();
	}

}
