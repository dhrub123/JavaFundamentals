package com.dhruba.java.concurrency.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class FirstCompletableFuture {

	public static void main(String[] args) throws InterruptedException {
		CompletableFuture.runAsync(() -> System.out
				.println("I am running asynchronously in the thread " + Thread.currentThread().getName()));
		// This will not print because this task will be executed in a thread of
		// fork-join pool
		// but main thread will die before that.
		// if we add a little sleep, we can see it printing
		Thread.sleep(100);

		// Pattern 2 : This is run in an executor thread
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Runnable task = () -> System.out
				.println("I am running asynchronously in the executor thread " + Thread.currentThread().getName());
		CompletableFuture.runAsync(task, executor);
		executor.shutdown();
		
		//Pattern3 : Supplier
		Supplier<String> supplier = () -> Thread.currentThread().getName();
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
		String string = completableFuture.join();//This is a blocking call
		System.out.println("Result " + string);
		
		//Pattern 4
		ExecutorService executor1 = Executors.newSingleThreadExecutor();
		Supplier<String> supplier1 = () -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			return Thread.currentThread().getName();
		};
		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(supplier1,executor1);
		String string1 = completableFuture1.join();//This is a blocking call
		System.out.println("Result " + string1);
		executor1.shutdown();
		
		//pattern 5 - Force completion of completable future
		executor1 = Executors.newSingleThreadExecutor();
		supplier1 = () -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			return Thread.currentThread().getName() + " force complete before join";
		};
		completableFuture1 = CompletableFuture.supplyAsync(supplier1,executor1);
		completableFuture1.complete("Too Long");//This will replace the value because the task has not yet completed
		string1 = completableFuture1.join();//This is a blocking call
		System.out.println("Result " + string1);
		executor1.shutdown();
		
		//pattern 5.1
		executor1 = Executors.newSingleThreadExecutor();
		supplier1 = () -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			return Thread.currentThread().getName() + " force complete after join";
		};
		completableFuture1 = CompletableFuture.supplyAsync(supplier1,executor1);
		string1 = completableFuture1.join();//This is a blocking call
		completableFuture1.complete("Too Long");//This will not replace the value because the task has completed
		System.out.println("Result " + string1);
		executor1.shutdown();
		
		//Pattern 6 - obtrude
		executor1 = Executors.newSingleThreadExecutor();
		supplier1 = () -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			return Thread.currentThread().getName() + " obtrude before join";
		};
		completableFuture1 = CompletableFuture.supplyAsync(supplier1,executor1);
		completableFuture1.obtrudeValue("Too Long for obtrude");//This will replace the value because of obtrude
		string1 = completableFuture1.join();//This is a blocking call
		System.out.println("Result " + string1);
		executor1.shutdown();
		
		//Pattern 6.1
		executor1 = Executors.newSingleThreadExecutor();
		supplier1 = () -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			return Thread.currentThread().getName() + " obtrude after join";
		};
		completableFuture1 = CompletableFuture.supplyAsync(supplier1,executor1);
		string1 = completableFuture1.join();//This is a blocking call
		completableFuture1.obtrudeValue("Too Long for obtrude");//This will replace the value because of obtrude
		string1 = completableFuture1.join();
		System.out.println("Result " + string1);
		executor1.shutdown();
		
		//Pattern 7 
		CompletableFuture<Void> cf = new CompletableFuture<>();
		Runnable task1 = () -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			cf.complete(null);//We complete this task 
		};
		CompletableFuture.runAsync(task1);//After 500 ms, the complete method will be called on the task
		Void nil = cf.join();
		System.out.println("We are done");
	}
}
