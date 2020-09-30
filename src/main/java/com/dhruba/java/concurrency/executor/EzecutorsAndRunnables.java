package com.dhruba.java.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EzecutorsAndRunnables {

	public static void main(String[] args) {
		Runnable task = () -> System.out.println("I am in thread " + Thread.currentThread().getName());

		for (int i = 0; i < 10; i++) {
			new Thread(task).start();
		}
		
		/*
		
		I am in thread Thread-1
		I am in thread Thread-3
		I am in thread Thread-0
		I am in thread Thread-2
		I am in thread Thread-5
		I am in thread Thread-4
		I am in thread Thread-6
		I am in thread Thread-7
		I am in thread Thread-8
		I am in thread Thread-9
		 */
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			service.execute(task);
		}
		
		/*
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		I am in thread pool-1-thread-1
		
		and the JVM is still running
		*/
		
		//So to shutdown JVM
		service.shutdown();
		
		service = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 10; i++) {
			service.execute(task);
		}
		service.shutdown();
		
		/*
     	I am in thread pool-2-thread-1
		I am in thread pool-2-thread-2
		I am in thread pool-2-thread-3
		I am in thread pool-2-thread-4
		I am in thread pool-2-thread-4
		I am in thread pool-2-thread-1
		I am in thread pool-2-thread-1
		I am in thread pool-2-thread-3
		I am in thread pool-2-thread-1
		I am in thread pool-2-thread-2
 		 */
		
	}

}
