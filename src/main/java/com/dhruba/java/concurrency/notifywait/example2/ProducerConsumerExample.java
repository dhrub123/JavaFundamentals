package com.dhruba.java.concurrency.notifywait.example2;

public class ProducerConsumerExample {
	
	private static Object lock = new Object();
	private static int[] buffer;
	private static int count;
	
	static class Consumer{
		void consume() throws InterruptedException {
			synchronized(lock) {
				if(isEmpty(buffer)) {
					lock.wait();
				}
				buffer[--count] = 0;
				lock.notifyAll();
			}
		}
	}
	
	static class Producer{
		void produce() throws InterruptedException {
			synchronized(lock) {
				if(isFull(buffer)) {
					lock.wait();
				}
				buffer[count++] = 1;
				lock.notifyAll();
			}
		}
	}
	
	static boolean isEmpty(int[] buffer) {
		return count == 0;
	}
	
	static boolean isFull(int[] buffer) {
		return count == buffer.length;
	}
	
	public static void main(String[] args) throws InterruptedException {
		buffer = new int[10];
		count = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable produceTask = () -> {
			for(int i = 0; i < 50 ; i++) {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Done producing");
		};
		
		Runnable consumeTask = () -> {
			for(int i = 0; i < 50 ; i++) {
				try {
					consumer.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Done consuming");
		};
		
		Thread producerThread = new Thread(produceTask);
		Thread consumerThread = new Thread(consumeTask);
		
		producerThread.start();consumerThread.start();
		producerThread.join();consumerThread.join();
		
		System.out.println("Data in buffer: " + count);
		
	}
	
}
