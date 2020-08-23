package designpatterns.creational.singleton;

public class ThreadSafeEfficientSingleton {
	
	private static ThreadSafeEfficientSingleton instance;
	private ThreadSafeEfficientSingleton() {}
	
	public static ThreadSafeEfficientSingleton getInstance() {
		if(instance == null) {
			synchronized (ThreadSafeEfficientSingleton.class) {
				if(instance == null) {
					instance = new ThreadSafeEfficientSingleton();
				}
			}
		}
		return instance;
	}
}
