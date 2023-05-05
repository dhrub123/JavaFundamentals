package three.multithreading.CompletableFuture;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CompletableFutureChainingDemo {

	public static void main(String[] args) {

		try {

			// thenCompose() - this takes output of previous future as input
			CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				return 50;
			});

			CompletableFuture<Integer> resultFuture = future
					.thenCompose(num -> CompletableFuture.supplyAsync(() -> num * 2));

			System.out.println(resultFuture.get());

			// thenCombine() - these combines 2 independent futures
			resultFuture = future.thenCombine(CompletableFuture.supplyAsync(() -> 20), (num1, num2) -> num1 + num2);
			System.out.println(resultFuture.get());
			
			//allOf()
			CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 50);
	        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 40);
	        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> 30);

	        CompletableFuture<Void> finalFuture = CompletableFuture.allOf(future1, future2, future3);
	        System.out.println(finalFuture.get()); 
	        System.out.println("Code that should be executed after all the futures complete.");
		
	        //join
	        Optional<Integer> maxElement = Stream.of(future1, future2, future3)
	        		.map(CompletableFuture::join)
	        		.max(Integer::compareTo);
	        System.out.println("The max element is " + maxElement);
	        
	        //anyOf
	        CompletableFuture<Object> firstCompletedFuture = CompletableFuture.anyOf(future1, future2, future3);
	        System.out.println(firstCompletedFuture.get());
	        
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
