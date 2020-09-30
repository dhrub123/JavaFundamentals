package com.dhruba.java.concurrency.advanced.barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierExample {
	
	public static void main(String[] args) {
		
		class Friend implements Callable<String>{

			private CyclicBarrier barrier;
			
			public Friend(CyclicBarrier barrier) {
				this.barrier = barrier;
			}

			public String call() throws Exception {
				
				try{
					Random random = new Random();
					Thread.sleep((random.nextInt(20)*100 + 100));
					System.out.println("I just arrived, waiting for others .....");
					barrier.await(5, TimeUnit.SECONDS);
					//we can add a timeout as fail-safe in case of issues
					/*
					 I just arrived, waiting for others .....
					I just arrived, waiting for others .....
					java.util.concurrent.BrokenBarrierException
					java.util.concurrent.TimeoutException
					I just arrived, waiting for others .....
					java.util.concurrent.BrokenBarrierException
					I just arrived, waiting for others .....
					java.util.concurrent.BrokenBarrierException
					 */
					//To fix this increase thread pool to 4
					System.out.println("Let us go to the cinema !!!");
					return "ok";
				}catch(InterruptedException e) {
					System.out.println("Interrupted");
				}
				return "not_ok";
			}
			
		}
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//If we do not have 4 threads in our thread pool, our barrier will never open
		//because the number of parties is defined as 4 in the barrier
		CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Barrier Opening"));
		List<Future<String>> futures = new ArrayList<>();
		
		try {

			for (int i = 0; i < 4; i++) {
				Friend friend = new Friend(barrier);
				futures.add(executorService.submit(friend));
			}
			futures.forEach(future -> {
				try {
					future.get(200, TimeUnit.MILLISECONDS);
				} catch (InterruptedException | ExecutionException e) {
					System.out.println(e.getMessage());
				} catch (TimeoutException e) {
					System.out.println("Timed Out");
					future.cancel(true);
				}
			});

		} finally {
			executorService.shutdown();
		}
		
	}
}
