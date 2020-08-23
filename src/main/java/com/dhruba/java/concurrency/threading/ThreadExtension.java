package com.dhruba.java.concurrency.threading;

public class ThreadExtension extends Thread {

	public ThreadExtension() {
		super("DemoThread");
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " Execute Thread");
	}

	public static void main(String[] args) {
		new ThreadExtension().start();
	}

}
