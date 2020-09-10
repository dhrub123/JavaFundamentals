package com.dhruba.java.concurrency.threading;

public class RunningDeadlockScenario {
	
	public static void main(String[] args) throws InterruptedException {
		DeadLockScenario deadLockScenario = new DeadLockScenario();
		
		//2 workers
		Runnable r1 = () -> deadLockScenario.a();
		Runnable r2 = () -> deadLockScenario.b();
		
		//2 threads
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();
		
		t1.join();
		t2.join();
	}
}
