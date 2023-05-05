package three.multithreading.FutureAndCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
	/*
	 * Runnable tasks with run method do not return value, Callables can be used to
	 * return values And those values can be retrieved using Future objects
	 */

  /*
   * To debug concurrent programs use jconsole and jstat in cmd
   */

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int halfway = Integer.MAX_VALUE / 2;
		CallableTask task1 = new CallableTask(1, halfway);
		CallableTask task2 = new CallableTask(halfway + 1, Integer.MAX_VALUE);

		ExecutorService threadpool = Executors.newFixedThreadPool(5);
		Future<Long> result1 = threadpool.submit(task1);
		Future<Long> result2 = threadpool.submit(task2);
		while(!result1.isDone() && !result2.isDone()) {
			System.out.println("Waiting for task1 and task 2 to complete");
		}
		System.out.println("Summation = " + (result1.get().longValue() + result2.get().longValue()));
		//.get is a blocking, it will wait until thread execution is complete to get result
		//.isDone can be used to poll

		threadpool.shutdown();
		
		
	}

}