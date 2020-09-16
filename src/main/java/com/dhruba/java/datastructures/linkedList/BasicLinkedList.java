package com.dhruba.java.datastructures.linkedList;

/**
 * 
 */

public class BasicLinkedList<X> {

	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	public int size() {
		return nodeCount;
	}

	public void add(X item) {
		if (first == null) {
			first = new Node(item);
			last = first;
		} else {
			Node newlastNode = new Node(item);
			last.setNextNode(newlastNode);
			last = newlastNode;
		}
		nodeCount++;
	}

	public X remove() {
		if (first == null) {
			throw new IllegalStateException("Linked List is empty");
		} else {
			X nodeItem = first.getNodeItem();
			first = first.getNextNode();
			nodeCount--;
			return nodeItem;
		}
	}

	public void insert(X item, int position) {
		if (first == null || size() < position) {
			throw new IllegalStateException("Linked List is empty or not enough items");
		} else {

			Node currentNode = first;
			for (int i = 1; i < position && currentNode != null; i++) {
				currentNode = currentNode.getNextNode();
			}

			Node newNode = new Node(item);
			Node nextNode = currentNode.nextNode;
			currentNode.setNextNode(newNode);
			newNode.setNextNode(nextNode);
			nodeCount++;
		}
	}

	public X removeAt(int position) {
		if (first == null || size() < position) {
			throw new IllegalStateException("Linked List is empty or not enough items");
		} else {

			Node currentNode = first;
			Node previousNode = first;
			for (int i = 1; i < position && currentNode != null; i++) {
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}

			X nodeItem = currentNode.getNodeItem();
			previousNode.setNextNode(currentNode.getNextNode());
			nodeCount--;
			return nodeItem;

		}
	}

	public int find(X nodeItem) {
		if (first == null) {
			throw new IllegalStateException("Linked List is empty or not enough items");
		} else {

			Node currentNode = first;
			for (int i = 1; i < size() && currentNode != null; i++) {
				if (currentNode.getNodeItem().equals(nodeItem)) {
					return i;
				}
				currentNode = currentNode.getNextNode();
			}
			// if we did not find
			return -1;

		}

	}

	public X get(int position) {

		if (first == null || size() < position) {
			throw new IllegalStateException("Linked List is empty or not enough items");
		} else {

			Node currentNode = first;
			for (int i = 1; i < size() && currentNode != null; i++) {
				if (i == position) {
					return currentNode.getNodeItem();
				}
				currentNode = currentNode.getNextNode();
			}
			// if we did not find
			return null;

		}

	}

	@Override
	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node currentNode = first;
		while (currentNode != null) {
			contents.append(currentNode.getNodeItem());
			currentNode = currentNode.getNextNode();

			if (currentNode != null) {
				contents.append(", ");
			}
		}
		return contents.toString();
	}

	private class Node {

		private Node nextNode;
		private X nodeItem;

		public Node(X nodeItem) {
			this.nextNode = null;
			this.nodeItem = nodeItem;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public X getNodeItem() {
			return nodeItem;
		}

	}

}
