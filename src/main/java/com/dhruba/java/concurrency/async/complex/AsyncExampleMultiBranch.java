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
import com.dhruba.java.concurrency.async.complex.model.Email;

import com.dhruba.java.concurrency.async.complex.model.User;

public class AsyncExampleMultiBranch {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Supplier<List<Long>> supplyIds = () -> {
			sleep(200);
			return Arrays.asList(1L, 2L, 3L);
		};
		
		Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
			sleep(250);
			Supplier<List<User>> userSupplier = () -> {
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};
		
		Function<List<Long>, CompletableFuture<List<Email>>> fetchEmails = emails -> {
			sleep(350);
			Supplier<List<Email>> emailSupplier = () -> {
				return emails.stream().map(Email::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(emailSupplier);
		};
		
		//Pattern 1 - on completion of both tasks
		CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIds);
		CompletableFuture<List<User>> userFuture = completableFuture.thenCompose(fetchUsers);
		CompletableFuture<List<Email>> emailFuture = completableFuture.thenCompose(fetchEmails);
		
		userFuture.thenAcceptBoth(emailFuture, (users, emails) -> {
			System.out.println(users.size() + " - " + emails.size());
		});
		
		
		//Pattern2 - on completion of 1 task
		
		Consumer<List<User>> displayer = users -> {
			users.forEach(System.out::println);
		};
		
		Function<List<Long>, CompletableFuture<List<User>>> fetchUsers1 = ids -> {
			sleep(150);
			Supplier<List<User>> userSupplier = () -> {
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};
		
		Function<List<Long>, CompletableFuture<List<User>>> fetchUsers2 = ids -> {
			sleep(5_000);
			Supplier<List<User>> userSupplier = () -> {
				return ids.stream().map(User::new).collect(Collectors.toList());
			};
			return CompletableFuture.supplyAsync(userSupplier);
		};
		
		CompletableFuture<List<User>> users1 = completableFuture.thenComposeAsync(fetchUsers1);
		CompletableFuture<List<User>> users2 = completableFuture.thenComposeAsync(fetchUsers2);
		
		users1.thenRun(() -> System.out.println("Users 1"));
		users2.thenRun(() -> System.out.println("Users 2"));
		users1.acceptEither(users2, displayer);
		
		sleep(6_000);//We add this otherwise main thread will die before other tasks are complete
		executor.shutdown();
	}
	
	public static void sleep(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			
		}
	}
}
