package three.multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {

	private CountDownLatch latch;

	public Worker(CountDownLatch latch, String name) {
		super(name);
		this.latch = latch;
	}

	public void run() {
		try {
			Thread.sleep(100);
			System.out.println("Thread " + Thread.currentThread().getName() + " started");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown(); //this is mandatory because it will signal that the work of the thread is complete

	}

}