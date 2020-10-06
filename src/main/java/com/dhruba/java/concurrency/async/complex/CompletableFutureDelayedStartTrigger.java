package com.dhruba.java.concurrency.async.complex;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.dhruba.java.concurrency.async.complex.model.User;

public class CompletableFutureDelayedStartTrigger {
	
	public static void main(String[] args) {
		
		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};
		
		Function<List<Long>, List<User>> fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};
		
		Consumer<List<User>> displayer = users -> {
			System.out.println("In thread " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};
		
		CompletableFuture<Void> start = new CompletableFuture<>();
		CompletableFuture<List<Long>> supply = start.thenApply(nil -> supplyIds.get());
		CompletableFuture<List<User>> fetch = supply.thenApply(fetchUsers);
		CompletableFuture<Void> display = fetch.thenAccept(displayer);
		start.complete(null);//We need to do this to trigger the chain
		sleep(1_000);
		System.out.println("==========================================================");
		
		//To run in another thread
		ExecutorService executor = Executors.newSingleThreadExecutor();
		start = new CompletableFuture<>();
		supply = start.thenApply(nil -> supplyIds.get());
		fetch = supply.thenApply(fetchUsers);
		display = fetch.thenAccept(displayer);
		start.complete(null);//start.completeAsync(() -> null, executor); From Java 9
		sleep(1_000);
		executor.shutdown();
		System.out.println("==========================================================");
		
	}
	
	public static void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			
		}
	}
}
