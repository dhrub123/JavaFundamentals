package com.dhruba.java.concurrency.synchronize;

public class SynchronizedTest {
	public static void main(String[] args) {
		MathClass mc = new MathClass();
		MathClassSyncMethod mcsm = new MathClassSyncMethod();
		
		//Create thread
		Runnable r = new Runnable() {
			
			public void run() {
				try {
					mc.printNumbers(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		new Thread(r,"One").start();
		new Thread(r,"Two").start();
		
		r = new Runnable() {
			
			public void run() {
				try {
					mcsm.printNumbers(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		new Thread(r,"One").start();
		new Thread(r,"Two").start();
	}
}
