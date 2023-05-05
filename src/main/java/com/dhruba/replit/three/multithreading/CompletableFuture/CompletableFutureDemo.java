package three.multithreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

	public static void main(String[] args) {

		try {
			/*CompletableFuture<Integer> completableFuture = getSquareAsynchronously(879);
			System.out.println(completableFuture.get());*/
			
			CompletableFuture<String> completableFutureString = CompletableFuture.completedFuture("Hello");
			System.out.println(completableFutureString.get());
			
			//Async operation
			CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Processed by " + Thread.currentThread().getName());
			});
			System.out.println("Print now " + Thread.currentThread().getName());
			future.get();//This will block the main thread so that async task can continue running
		
			//We can provide our thread to completable future instead of using default fork join pool
			ExecutorService executor = Executors.newFixedThreadPool(5);
			future = CompletableFuture.runAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Processed by " + Thread.currentThread().getName());
			}, executor);
			System.out.println("Print now " + Thread.currentThread().getName());
			future.get();//This will block the main thread so that async task can continue running
		
			//to get result of computation we can use supplyasync
			completableFutureString = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Hello Async printed after 5 seconds";
			});
			System.out.println(completableFutureString.get());
			
			//overloaded supplyasync also takes executor
			completableFutureString = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Hello Async printed after 5 seconds";
			}, executor);
			System.out.println(completableFutureString.get()); 
			executor.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static CompletableFuture<Integer> getSquareAsynchronously(int num) throws InterruptedException{
		CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(50);
			completableFuture.complete(num * num);
			return null;
		});
		return completableFuture;
	}

}
