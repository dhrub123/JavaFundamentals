package three.multithreading.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
	//read and write lock and unlock - blocking calls
	static Map<String, Integer> data = new HashMap<>();
	static StampedLock lock = new StampedLock();

	public static Integer readDataFromMap(String key) {
		long stamp = lock.readLock();
		try {
			return data.get(key);
		} finally {
			lock.unlockRead(stamp);
		}
	}

	public static void writeDataToMap(String key, Integer value) {
		long stamp = lock.writeLock();
		try {
			data.put(key, value);
		} finally {
			lock.unlockWrite(stamp);
		}
	}
	
	public static Integer readDataFromMapNB(String key) {
		long stamp = lock.tryReadLock();
		try {
			return data.get(key);
		} finally {
			lock.unlockRead(stamp);
		}
	}

	public static void writeDataToMapNB(String key, Integer value) {
		long stamp = lock.tryWriteLock();
		try {
			data.put(key, value);
		} finally {
			lock.unlockWrite(stamp);
		}
	}
	
	public static Integer readDataFromMapOptimistic(String key) {
        int result = 0;
        long stamp = lock.tryOptimisticRead();

        if(stamp != 0L){
                result = data.get(key);
        }

        if (!lock.validate(stamp)) {
        // This means that the data was modified after we called optimistic read.
        // Do extra work here to get the latest data.
        }
        return result;
    }
	
	public static void writeDataToMapOptimistic(String key, Integer value) {
        long stamp = lock.tryWriteLock();
        if(stamp != 0L){
            try {
                data.put(key, value);
            } finally {
                lock.unlockWrite(stamp);
            }
        }
    }

	public static void main(String[] args) {
		writeDataToMap("ray", 123);
		Integer value = readDataFromMap("ray");
		System.out.println(value);
		
		writeDataToMapNB("don", 456);
		value = readDataFromMapNB("don");
		System.out.println(value);
		
		writeDataToMapOptimistic("jason", 789);
		value = readDataFromMapOptimistic("jason");
		System.out.println(value);

	}

}
