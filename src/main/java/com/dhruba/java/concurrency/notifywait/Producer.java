package com.dhruba.java.concurrency.notifywait;

import java.util.List;

public class Producer implements Runnable {
	
	private List<Integer> taskQueue;
	private int MAX_CAPACITY;
	
	
	public Producer(List<Integer> taskQueue, int mAX_CAPACITY) {
		this.taskQueue = taskQueue;
		MAX_CAPACITY = mAX_CAPACITY;
	}

	public void run() {
		int counter = 0;
		while(true) {
			try {
				produce(counter++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void produce(int i) throws InterruptedException {
		synchronized (taskQueue) {
			while(taskQueue.size() == MAX_CAPACITY) {
				System.out.println("Queue full");
				taskQueue.wait();
			}
			
			Thread.sleep(1000);
			taskQueue.add(i);
			System.out.println("Produced " + i);
			taskQueue.notifyAll();
		}
	}

}
