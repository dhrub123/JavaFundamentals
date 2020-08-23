package com.dhruba.java.concurrency.notifywait;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	public static void main(String[] args) {
		List<Integer> taskQueue = new ArrayList<Integer>();
		int MAX_CAPACITY = 5;
		Thread producer = new Thread(new Producer(taskQueue, MAX_CAPACITY),"Producer");
		Thread consumer = new Thread(new Consumer(taskQueue),"Consumer");
		producer.start();
		consumer.start();
	}
}
