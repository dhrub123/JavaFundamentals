package com.dhruba.java.concurrency.threading;

public class LongWrapper {

	private long l;
	private Object key = new Object();

	public LongWrapper(long l) {
		this.l = l;
	}

	public long getL() {
		return l;
	}

	/*
	 * This is not atomic public void incrementValue() { l = l + 1; }
	 */

	public void incrementValue() {
		synchronized (key) {
			l = l + 1;
		}
	}

}
