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

public class AsyncExample {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor2 = Executors.newSingleThreadExecutor();
		
		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};
		
		Function<List<Long>, List<User>> fetchUsers = ids -> {
			sleep(300);
			System.out.println("Currently Running in " + Thread.currentThread().getName());
			return ids.stream().map(User::new).collect(Collectors.toList());
		};
		
		Consumer<List<User>> displayer = users -> {
			System.out.println("Running in " + Thread.currentThread().getName());
			users.forEach(System.out::println);
		};
		
		//Pattern 1
		CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIds);
		completableFuture.thenApply(fetchUsers).thenAccept(displayer);
		
		sleep(1_000);//We add this otherwise main thread will die before other tasks are complete
		
		//pattern 2
		
		completableFuture = CompletableFuture.supplyAsync(supplyIds);
		completableFuture.thenApply(fetchUsers).thenAcceptAsync(displayer,executor);
		sleep(1_000);
		executor.shutdown();
		
		
		//pattern 3 asynchronous
		Function<List<Long>, CompletableFuture<List<User>>> fetchUsersCF = ids -> {
			sleep(300);
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Currently Running in " + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};
		executor = Executors.newSingleThreadExecutor();
		completableFuture = CompletableFuture.supplyAsync(supplyIds);
		completableFuture.thenCompose(fetchUsersCF).thenAcceptAsync(displayer,executor);
		sleep(1_000);
		executor.shutdown();
		
		//pattern 4 asynchronous
		Function<List<Long>, CompletableFuture<List<User>>> fetchUsersCFWithExecutorInSupplier = ids -> {
			sleep(300);
			Supplier<List<User>> userSupplier = () -> {
				System.out.println("Currently Running in " + Thread.currentThread().getName());
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier, executor2);
		};
		executor = Executors.newSingleThreadExecutor();
		//executor2 = Executors.newSingleThreadExecutor();
		completableFuture = CompletableFuture.supplyAsync(supplyIds);
		completableFuture.thenComposeAsync(fetchUsersCFWithExecutorInSupplier,executor2).thenAcceptAsync(displayer,executor);
		sleep(1_000);
		executor.shutdown();
		executor2.shutdown();
		
	}
	
	public static void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			
		}
	}
}
