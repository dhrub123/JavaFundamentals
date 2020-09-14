package com.dhruba.java.datastructures.queue;

/**
 * TODO: Implement with ArrayList
 */
public class BasicQueue<X> implements Queue<X>{
	
	private X[] data;

	private int front;
	private int end;
	
	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[])new Object[size];
	}

	public BasicQueue() {
		this(1000);
	}
	
	@Override
	public void enQueue(X item) {
		// check to see if queue is full
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("Queue is Full");
		}
		// otherwise check if items have been added to queue
		if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		}
		// otherwise add item
		else {
			end++;
			data[end] = item;
		}

	}

	@Override
	public X dequeue() {

		X item = null;
		// empty queue
		if (size() == 0) {
			throw new IllegalStateException("No Data in queue");
		} // last item in queue
		else if (front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;

		} else {
			item = data[front];
			data[front] = null;
			front++;
		}
		return item;

	}
	
	@Override
	public boolean contains(X item) {
		boolean contains = false;
		
		if(size() == 0) {
			return contains;
		}
		for(int i=front; i < end; i++) {
			if(data[i].equals(item)) {
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	@Override
	public X access(int position) {
		if(size() == 0 || position > size()) {
			throw new IllegalStateException("No Data in queue or position greater than length of queue");
		}
		
		int trueIndex = 0;
		for(int i=front; i < end; i++) {
			if(trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}
		
		throw new IllegalStateException("Could not find data in queue");
	}
	
	@Override
	public int size() {
		if(front == -1 && end == -1) {
			return 0;
		}
		return end - front + 1;
	}
	
}
