CompletableFuture
-----------------
1. Belongs to java.util.concurrent package
2. Asynchronous computation, code is executed as a non-blocking call in a seperate thread.
3. The CompletableFuture class implements CompletionStage(This is a promise) and Future interface.

Limitations of Future Interface
-------------------------------
1. Futher action cannot be performed on future's result without blocking. get() blocks till computation is complete.
2. Chaining of future is not possible
3. Combining multiple futures running in parallel is not possible
4. No exception handling mechanism

Processing result of Completable Future
---------------------------------------
When we do CompletableFuture.get() it becomes blocking call. For true async
execution we need to attach to the CompletableFuture which should automatically execute when the completableFuture completes.
1. thenApply()
2. thenApplyAsync(Function<T, R> function)
3. thenApplyAsync(Function<T, R> function, Executor executor)
4. thenAccept() - when we do not want to return anything from callback
5. thenRun() - when we do not want to return anything from callback, takes runnable as parameter, thenAccept() has access to the result of the future, thenRun() does not even has access to the result

Chaining CompletableFutures
---------------------------
When we chain 2 CompletableFutures, the 1st one shares its result with the second one.
1. thenCompose() - this takes output of previous future as input
2. thenCombine() - these combines 2 independent futures

Combining CompletableFutures
----------------------------
allOf() - since allOf() returns CompletableFuture<Void>, we cannot combine result of all the completablefutures.
1. It returns a new CompletableFuture that is completed when all of the given CompletableFutures are completed.
2. If any of the given CompletableFutures complete exceptionally, the returned CompletableFuture also completes, with a CompletionException holding this exception as its cause.
3. The results, if any, of the given CompletableFutures are not reflected in the returned CompletableFuture, but they may be obtained by inspecting them individually.
4. If no CompletableFutures are provided, it returns a CompletableFuture completed with the value null.

join() - to combine result of all futures, returns result value when complete or throws an unchecked  exception if completed with exception.

anyOf() 
1. It returns a new CompletableFuture that is completed when any of the given CompletableFutures complete with the same result.
2. If it is completed exceptionally, the returned CompletableFuture also does so, with a CompletionException holding this exception as its cause.
3. If no CompletableFutures are provided, it returns an incomplete CompletableFuture.