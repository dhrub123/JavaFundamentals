The ReentrantReadWriteLock and its drawbacks
--------------------------------------------
1. Multiple threads can acquire a read lock simultaneously.
2. Only one thread can acquire a write lock.
3. If a thread wants to acquire a write lock and there are some threads that have read lock, the thread will wait until all the threads release the read lock.

Problems with ReentrantReadWriteLock:
1. It can lead to starvation.
2. Sometimes it can be significantly slower than other synchronizers.

Improvements provided by StampedLock:
-------------------------------------
1. It provides methods to upgrade read lock to write lock.
2. It has 3 locking modes:
    a. Read - readLock() - blocking - returns a stamp to be used to release lock, unlockRead(long stamp) - blocking - release read lock, tryReadLock() - acquire lock immediately if available else do not block, tryReadLock(long time, TimeUnit unit) - Try to acquire lock till provided time limit
    b. Write - writeLock() - blocking - returns a stamp to be used to release lock, unlockWrite(long stamp) - blocking - release write lock, tryWriteLock() - acquire lock immediately if available else do not block, tryWriteLock(long time, TimeUnit unit) - Try to acquire lock till provided time limit
    c. Optimistic read- when data is read frequently and rarely updated, it is not advisable to get a read lock every time a read is done. instead tryOptimisticRead()
  1. If some other thread has already acquired a write lock, 
     thread t1 returns. It is not able to acquire the lock.
  2. If some other thread has already acquired a read lock then 
     tryOptimisticRead() returns an observation stamp.
     Please note that we have not acquired a lock. We have just 
     received an observation stamp.
  3. Now, thread t1 will completes the reading, and then it calls 
     the validate(long stamp) method. This method tells if a write 
     operation after the observation stamp was generated.
  4. If the validation is successful, it means we have the most 
     recent data and we are good.
  5. If the validation is not successful, it means that we may not 
     have the most recent data and we need to do something else.
The benefit of optimizing locking is that we are not actually acquiring the lock so it is a cheap operation.

Converting Lock Modes:
----------------------
In the StampedLock class, it is possible to convert one lock mode to another, i.e., we can convert a read lock to a write lock and vice versa.
```
1. tryConvertToWriteLock(long stamp)
   > If the lock we are trying to convert is already a write lock, 
     then return the lock.
   > If the lock we are trying to convert is a read lock and a 
     write lock is available then return the write lock and 
     release the read lock.
   > If the lock we are trying to convert is an optimistic read 
     lock, then return the write lock if available.
   > Return zero.
2. tryConvertToReadLock(long stamp)
   > If the lock we are trying to convert is already a read lock 
     then return the lock.
   > If the lock we are trying to convert is a write lock then 
     return the read lock and release write lock.
   > If the lock we are trying to convert is an optimistic read 
     lock, and then return the read lock if it is available.
   > Return zero.
3. tryConvertToOptimisticRead(long stamp)
   > If the stamp represents an optimistic read lock, then return 
     it if it is validated.
   > If the stamp represents a lock then release the lock and 
     return an observation stamp.
   > Return zero.
```