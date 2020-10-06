package com.dhruba.java.concurrency.async.complex.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.dhruba.java.concurrency.async.complex.model.User;

public class ExceptionExample {

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
			users.forEach(System.out::println);
		};
		
		CompletableFuture<List<Long>> supply = CompletableFuture.supplyAsync(supplyIds);
		CompletableFuture<List<User>> fetch = supply.thenApply(fetchUsers);
		CompletableFuture<Void> display = fetch.thenAccept(displayer);
		
		sleep(1_000);
		System.out.println("Supply : done = " + supply.isDone() + " exception = " + supply.isCompletedExceptionally());
		System.out.println("Fetch : done = " + fetch.isDone() + " exception = " + fetch.isCompletedExceptionally());
		System.out.println("Display : done = " + display.isDone() + " exception = " + display.isCompletedExceptionally());
		System.out.println("=====================================================");
		
		//Simulate Exceptions
		supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
		};
		
		fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};
		
		displayer = users -> {
			users.forEach(System.out::println);
		};
		
		supply = CompletableFuture.supplyAsync(supplyIds);
		fetch = supply.thenApply(fetchUsers);
		display = fetch.thenAccept(displayer);
		
		sleep(1_000);
		System.out.println("Supply : done = " + supply.isDone() + " exception = " + supply.isCompletedExceptionally());
		System.out.println("Fetch : done = " + fetch.isDone() + " exception = " + fetch.isCompletedExceptionally());
		System.out.println("Display : done = " + display.isDone() + " exception = " + display.isCompletedExceptionally());
		System.out.println("=====================================================");
		
		//handling exceptionally pattern 1
		supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
		};
		
		fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};
		
		displayer = users -> {
			users.forEach(System.out::println);
		};
		
		supply = CompletableFuture.supplyAsync(supplyIds);
		CompletableFuture<List<Long>> exception = supply.exceptionally(e -> {
			return new ArrayList<Long>();
		});
		fetch = exception.thenApply(fetchUsers);
		display = fetch.thenAccept(displayer);
		
		//supply.join();//This will throw the exception
		
		sleep(1_000);
		System.out.println("Supply : done = " + supply.isDone() + " exception = " + supply.isCompletedExceptionally());
		System.out.println("Fetch : done = " + fetch.isDone() + " exception = " + fetch.isCompletedExceptionally());
		System.out.println("Display : done = " + display.isDone() + " exception = " + display.isCompletedExceptionally());
		System.out.println("=====================================================");
		
		//handling exceptionally pattern 2
		supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
		};
		
		fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};
		
		displayer = users -> {
			users.forEach(System.out::println);
		};
		
		supply = CompletableFuture.supplyAsync(supplyIds);
		exception = supply.whenComplete((ids , e) -> {
			if(e != null) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		});
		fetch = exception.thenApply(fetchUsers);
		display = fetch.thenAccept(displayer);
		
		
		sleep(1_000);
		System.out.println("Supply : done = " + supply.isDone() + " exception = " + supply.isCompletedExceptionally());
		System.out.println("Fetch : done = " + fetch.isDone() + " exception = " + fetch.isCompletedExceptionally());
		System.out.println("Display : done = " + display.isDone() + " exception = " + display.isCompletedExceptionally());
		System.out.println("=====================================================");
		
		//handling exceptionally pattern 3
		supplyIds = () -> {
			sleep(200);
			throw new IllegalStateException("No Data");
		};
		
		fetchUsers = ids -> {
			sleep(300);
			return ids.stream().map(User::new).collect(Collectors.toList());
		};
		
		displayer = users -> {
			users.forEach(System.out::println);
		};
		
		supply = CompletableFuture.supplyAsync(supplyIds);
		exception = supply.handle((ids , e) -> {
			if(e!= null) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return new ArrayList<Long>();
			}else {
				return ids;
			}
		});
		fetch = exception.thenApply(fetchUsers);
		display = fetch.thenAccept(displayer);
		
		
		sleep(1_000);
		System.out.println("Supply : done = " + supply.isDone() + " exception = " + supply.isCompletedExceptionally());
		System.out.println("Fetch : done = " + fetch.isDone() + " exception = " + fetch.isCompletedExceptionally());
		System.out.println("Display : done = " + display.isDone() + " exception = " + display.isCompletedExceptionally());
		System.out.println("=====================================================");
		
	}
	
	public static void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			
		}
	}
}
