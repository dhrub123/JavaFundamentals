package com.dhruba.java.concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallablesAndFutures {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException{
		
		Callable<String> task = () -> {
			Thread.sleep(300);
			return "I am in thread " + Thread.currentThread().getName();
		};
		
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(int i = 0; i<10; i++) {
			Future<String> result = service.submit(task);
			System.out.println("I get: " + result.get());
		}
		
		service.shutdown();
		
		/*
		I get: I am in thread pool-1-thread-1
		I get: I am in thread pool-1-thread-2
		I get: I am in thread pool-1-thread-3
		I get: I am in thread pool-1-thread-4
		I get: I am in thread pool-1-thread-1
		I get: I am in thread pool-1-thread-2
		I get: I am in thread pool-1-thread-3
		I get: I am in thread pool-1-thread-4
		I get: I am in thread pool-1-thread-1
		I get: I am in thread pool-1-thread-2
		 */
		
		//We can also add a timeout to get
		service = Executors.newFixedThreadPool(4);
		try {
			for (int i = 0; i < 10; i++) {
				Future<String> result = service.submit(task);
				System.out.println("I get: " + result.get(100, TimeUnit.MILLISECONDS));
			}
		} finally {
			service.shutdown();
		}
		
		Callable<String> taskThrowingException = () -> {
			throw new IllegalStateException("I throw an exception in thread " + Thread.currentThread().getName());
		};
		
		service = Executors.newFixedThreadPool(4);
		try {
			for (int i = 0; i < 10; i++) {
				Future<String> result = service.submit(taskThrowingException);
				System.out.println("I get: " + result.get());
			}
		} finally {
			service.shutdown();
		}
		
		/*
		Exception in thread "main" java.util.concurrent.ExecutionException: java.lang.IllegalStateException: I throw an exception in thread pool-3-thread-1
			at java.util.concurrent.FutureTask.report(FutureTask.java:122)
			at java.util.concurrent.FutureTask.get(FutureTask.java:192)
			at com.dhruba.java.concurrency.executor.CallablesAndFutures.main(CallablesAndFutures.java:60)
		Caused by: java.lang.IllegalStateException: I throw an exception in thread pool-3-thread-1
			at com.dhruba.java.concurrency.executor.CallablesAndFutures.lambda$1(CallablesAndFutures.java:53)
			at java.util.concurrent.FutureTask.run(FutureTask.java:266)
			at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
			at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
			at java.lang.Thread.run(Thread.java:748)
		 */
	}

}
