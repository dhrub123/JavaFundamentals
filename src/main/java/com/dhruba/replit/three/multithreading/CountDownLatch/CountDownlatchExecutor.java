package three.multithreading.CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownlatchExecutor {
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch latch = new CountDownLatch(2);
		Worker a = new Worker(latch, "A");
		Worker b = new Worker(latch, "B");
		a.start();
		b.start();
		
		latch.await();
		/* makes the master thread wait for the worker threads with latches to be complete.
		 * The threads a and b must do a countdown of the latch to indicate that they are done.
		 * The latch is not reusable
		 * */
		
		Master master = new Master();
		master.start();
	}
}