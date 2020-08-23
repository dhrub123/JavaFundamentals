package com.dhruba.java.concurrency.synchronize;

public class MathClass {

	public void printNumbers(int n) throws InterruptedException {
		synchronized (this) {
			for (int i = 0; i < n; i++) {
				System.out.println(Thread.currentThread().getName() + " ::" + i);
				Thread.sleep(500);
			}

		}
	}
}
