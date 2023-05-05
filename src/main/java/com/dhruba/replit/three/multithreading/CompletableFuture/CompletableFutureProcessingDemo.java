package three.multithreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureProcessingDemo {

	public static void main(String[] args) {
		
		try {
			//thenapply
			CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Processed by " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 50;
			});
			
			CompletableFuture<Integer> resultFuture = future.thenApply(n -> {
				System.out.println("Processed by " + Thread.currentThread().getName());
				return n * 2;
			});
			System.out.println(resultFuture.get());
			
			//thenApplyAsync(Function<T, R> function) - to make a different thread execute callback
			future = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Processed by " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 50;
			});
			
			resultFuture = future.thenApplyAsync(n -> {
				System.out.println("Processed by " + Thread.currentThread().getName());
				return n * 2;
			});
			System.out.println(resultFuture.get());
			
			//thenApplyAsync(Function<T, R> function, Executor executor) -- with executor
			ExecutorService executor = Executors.newFixedThreadPool(5);
			future = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
					System.out.println("Processed by " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 50;
			},executor);
			
			resultFuture = future.thenApplyAsync(n -> {
				System.out.println("Processed by " + Thread.currentThread().getName());
				return n * 2;
			},executor);
			System.out.println(resultFuture.get());
			
			//thenAccept() - when we do not want to return anything from callback
			future = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Processed by " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 50;
			});
			future.thenAccept(n -> {
				System.out.println("Processed by " + Thread.currentThread().getName());
				System.out.println("The value is " + n);
			});
			
			//thenRun() - when we do not want to return anything from callback, takes runnable as parameter, 
			//thenAccept() has access to the result of the future, thenRun() does not even has access to the result
			future = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Processed by " + Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 50;
			});
			future.thenRun(() -> {
				System.out.println("Processed by " + Thread.currentThread().getName());
				System.out.println("Hello");
			});
			TimeUnit.SECONDS.sleep(10);
			executor.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

}
