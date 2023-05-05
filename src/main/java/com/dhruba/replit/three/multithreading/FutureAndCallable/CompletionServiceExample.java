package three.multithreading.FutureAndCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample {
	/*
	 * When many threads return many values, we cannot use many future objects
	 * Instead we use ExecutorCompletionService to listen for all the results
	 */

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int halfway = Integer.MAX_VALUE / 2;
		CallableTask task1 = new CallableTask(1, halfway);
		CallableTask task2 = new CallableTask(halfway + 1, Integer.MAX_VALUE);

		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		ExecutorCompletionService<Long> service = new ExecutorCompletionService<>(threadpool);
		service.submit(task1);
		service.submit(task2);
		//Listen for results
		int count = 2;
		while (count != 0) {
			Future<Long> result = service.poll();
			if (result != null) {
				System.out.println(result.get());
				count--;
			}
		}
		threadpool.shutdown();

	}

}