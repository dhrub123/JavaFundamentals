package com.dhruba.java.datastructures.queue;

public interface Queue<X> {

	void enQueue(X item);

	X dequeue();

	boolean contains(X item);

	X access(int position);

	int size();

}