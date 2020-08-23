package com.dhruba.java.concurrency.notifywait;

import java.util.List;

public class Consumer implements Runnable {
	
	private List<Integer> taskQueue;
	
	
	public Consumer(List<Integer> taskQueue) {
		this.taskQueue = taskQueue;
	}

	public void run() {
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	private void consume() throws InterruptedException {
		synchronized (taskQueue) {
			while(taskQueue.isEmpty()) {
				System.out.println("Queue is Empty");
				taskQueue.wait();
			}
			
			Thread.sleep(1000);
			int i = (Integer)taskQueue.remove(0);
			System.out.println("Consumed " + i);
			taskQueue.notifyAll();
		}
	}

}
