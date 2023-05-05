package three.multithreading.CyclicBarrierExample;

import java.util.concurrent.CyclicBarrier;

public class CBExecutor {
	public static void main(String[] args) throws Exception {
		
		BarrierAction action = new BarrierAction();
		CyclicBarrier cb = new CyclicBarrier(3, action);
		/**
		 * Here we are waiting for all threads, in this case 3 to reach the barrier.
		 * Once all three are submitted, the cyclic barrier will be breached and 
		 * execution started. A barrier is reusable.
		 * **/
		Thread one = new Thread(new Task(cb),"1");
		Thread two = new Thread(new Task(cb),"2");
		Thread three = new Thread(new Task(cb),"3");
		
		one.start();
		two.start();
		Thread.sleep(10000);
		three.start();
	}
}