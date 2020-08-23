package com.dhruba.java.concurrency.threading;

public class RunnableDemo implements Runnable {

	public void run() {
		System.out.println("Execute thread");
	}
	
	public static void main(String[] args) {
		new Thread(new RunnableDemo()).start();
	}

}
