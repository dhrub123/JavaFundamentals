package com.dhruba.java.datastructures.hash;

public class BasicHashTable<X, Y> {

	private HashEntry[] data;
	private int capacity;
	private int size;
	
	public BasicHashTable(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[this.capacity];
		this.size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public Y get(X key) {
		int hash = calculateHash(key);
		if(data[hash] == null) {
			return null;
		}else {
			return (Y)data[hash].getValue();
		}
	}
	
	public void put(X key, Y value) {
		int hash = calculateHash(key);
		data[hash] = new HashEntry<X, Y>(key, value);
		size++;
	}
	
	public Y delete(X key) {
		Y value = get(key);
		//clear out hash table slot
		if(value!= null) {
			int hash = calculateHash(key);
			data[hash] = null;
			size--;
			hash = (hash+1)%this.capacity;
			
			//if next slot is not empty
			while(data[hash]!= null) {
				HashEntry<X, Y> he = data[hash];
				data[hash] = null;
				System.out.println("Rehashing: " + he.getKey() + " - " + he.getValue());
				put((X)he.getKey(),(Y)he.getValue());
				//we repositioned the item and did not ad a new item, so
				size--;
				hash=(hash+1)%this.capacity;
			}
		}System.out.println(" ");
		return value;
	}//there will be a problem if table is full, because we will have a lot of collisions
	//best O(N) to worst O(N^2)
	
	public boolean hasKey(X key) {
		boolean found = false;
		int hash = calculateHash(key);
		if(data[hash] == null) {
			return found;
		}else {
			if(data[hash].getKey().equals(key)) {
				return true;
			}
		}
		return found;
	}//close to a constant time O(1)
	
	public boolean hasValue(Y value) {
		boolean found = false;
		for(int i=0; i < data.length; i++) {
			HashEntry<X, Y> entry = data[i];
			if(entry != null && entry.getValue().equals(value)) {
				return true;
			}
		}
		return found;
	}//Always linear because of loop O(n)
	
	//best case - no collisions - constant time
	//worst case - linear time since looping
	private int calculateHash(X key) {
		int hash = (key.hashCode()%this.capacity);
		//for collisions
		while(data[hash] != null && !data[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;// if item present in slot and key is not same 
											  //as key provided, we move 1 up
		}
		return hash;
	}

	private class HashEntry<X, Y> {

		private X key;
		private Y value;

		public HashEntry(X key, Y value) {
			this.key = key;
			this.value = value;
		}

		public X getKey() {
			return key;
		}

		public void setKey(X key) {
			this.key = key;
		}

		public Y getValue() {
			return value;
		}

		public void setValue(Y value) {
			this.value = value;
		}

	}
}
