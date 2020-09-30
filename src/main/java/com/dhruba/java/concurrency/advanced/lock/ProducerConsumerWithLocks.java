package com.dhruba.java.concurrency.advanced.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLocks {
	
	public static boolean isEmpty(List<Integer> buffer) {
		return buffer.size() == 0;
	}
	
	public static boolean isFull(List<Integer> buffer) {
		return 50 == buffer.size();
	}
	
	public static void main(String[] args) throws InterruptedException{

		List<Integer> buffer = new ArrayList<>();
		Lock lock = new ReentrantLock();
		Condition isEmpty = lock.newCondition();
		Condition isFull = lock.newCondition();
		
		class Consumer implements Callable<String> {

			public String call() throws InterruptedException, TimeoutException {
				int count = 0;
				while (count++ < 50) {
					try {
						lock.lock();
						while (isEmpty(buffer)) {
							//We add timeout so that consumer thread is interrupted in case 
							//there is issue with producers and no production happens
							if(!isEmpty.await(10, TimeUnit.MILLISECONDS)) {
								throw new TimeoutException("Consumer TimeOut");
							};
						}
						buffer.remove(buffer.size() - 1);
						isFull.signalAll();
					} finally {
						lock.unlock();
					}

				}
				return "Consumed " + (count - 1);
			}

		}

		class Producer implements Callable<String> {

			public String call() throws InterruptedException {
				int count = 0;
				while (count++ < 50) {
					try {
						lock.lock();
						//We have erroneous code - if we remove this code, there will be no errors
						int i = 10/0;
						while (isFull(buffer)) {
							isFull.await();
						}
						buffer.add(1);
						isEmpty.signalAll();
					} finally {
						lock.unlock();
					}

				}
				return "Produced " + (count - 1);
			}

		}

		List<Producer> producers = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			producers.add(new Producer());
		}
		
		List<Consumer> consumers = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			consumers.add(new Consumer());
		}
		
		System.out.println("Producers and Consumers launched");
		List<Callable<String>> producersAndConsumers = new ArrayList<>();
		producersAndConsumers.addAll(producers);
		producersAndConsumers.addAll(consumers);
		
		//be careful about the number of threads -- We need to have enough threads for producer and consumer
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		try {
			
			List<Future<String>> futures = executorService.invokeAll(producersAndConsumers);
			
			futures.forEach(future ->{
				try {
					System.out.println(future.get());
				}catch(InterruptedException | ExecutionException e) {
					System.out.println("Exception: " + e.getMessage());
				}
			});
		}finally {
			executorService.shutdown();
			System.out.println("Executor Service has been shhut down");
		}
		
	}

}
