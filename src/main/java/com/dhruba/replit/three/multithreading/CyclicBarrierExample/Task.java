package three.multithreading.CyclicBarrierExample;

import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {

	private CyclicBarrier barrier;
	
	public Task(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName() + " waiting on barrier");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " crossed barrier");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		

	}

}