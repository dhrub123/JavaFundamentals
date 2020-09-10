package com.dhruba.java.concurrency.threading;

public class DeadLockScenario {
	
	private Object key1 = new Object();
	private Object key2 = new Object();
	
	/**
	 * A has key1 and calls B and needs key2 for that. 
	 * But B calls C and needs key1 for that which is with A.
	 * So possible deadlock
	 */
	
	public void a() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in a()");
			b();
		}
	}
	
	public void b() {
		synchronized (key2) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in b()");
			c();
		}
	}
	
	public void c() {
		synchronized (key1) {
			System.out.println("[" + Thread.currentThread().getName() + "] I am in c()");
		}
	}
	
}
