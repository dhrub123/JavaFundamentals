package com.dhruba.java.concurrency.executor;

import java.util.concurrent.Executor;
//Wip
public class Invoker implements Executor {

	public void execute(Runnable r) {
		r.run();
	}
	
	public static void main(String[] args) {
		Executor executor = new Invoker();
		//If executor cannot accept task for execution 
		//it will throw RejectedExecutionException
		executor.execute(() -> {
			System.out.println("Thread executed");
		}); 
	}

}
