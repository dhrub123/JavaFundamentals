package com.dhruba.java.datastructures.stack;

/**
 * This stack has some limitations.
 * 
 * TODO: Also we need to add resizing code
 * 
 * TODO: We can implement this stack with arraylist to get default resizing
 */
public class BasicStack<X> implements Stack<X> {
	
	//No getters and setters
	private X[] data;
	private int stackPointer;

	public BasicStack() {
		this.data = (X[]) new Object[1000];
		stackPointer = 0;
	} 
		
	@Override
	public void push(X newItem) {
		//++ is post increment, new item gets assigned 
		//and then stack pointer gets incremented
		data[stackPointer++] = newItem;
	}
	
	@Override
	public X pop() {
		//we are pre decrementing the stackpointer and then
		//returning object at that pointer
		//we need to add guard code for stackpointer = 0
		if(stackPointer == 0) {
			throw new IllegalStateException("No items in stack");
		}
		return data[--stackPointer];
	}
		
	@Override
	public boolean contains(X item) {
		boolean found = false;
		for(int i=0; i< stackPointer; i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
		
	@Override
	public X access(X item) {
		while(stackPointer>0) {
			X tempItem = pop();
			if(tempItem.equals(item)) {
				return tempItem;
			}
		}
		
		//if we did not find the item
		throw new IllegalStateException("Could not find item in stack " + item);
	}
	
	@Override
	public int size() {
		return stackPointer;
	}
}
