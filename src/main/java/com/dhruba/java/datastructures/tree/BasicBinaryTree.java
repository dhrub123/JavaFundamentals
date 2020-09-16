package com.dhruba.java.datastructures.tree;

/**
 * 
 * TODO: create a rebalance method , use tree rotation
 * TODO: print or toString() of binary tree using depth
 */
public class BasicBinaryTree<X extends Comparable<X>>  {

	private Node root;
	private int size;
	
	public BasicBinaryTree() {
		this.root = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(X item) {
		boolean found = false;
		Node currentNode = getNode(item);
		if(currentNode == null) {
			return found;
		}else {
			found = true;
		}
		return found;
	}
	
	private Node getNode(X item) {
		
		Node currentNode = this.root;
		while(currentNode!= null) {
			int val = item.compareTo(currentNode.getItem());
			
			if(val == 0) {
				return currentNode;
			}else if(val <0) {
				currentNode = currentNode.getLeft();
			}else if(val >0) {
				currentNode = currentNode.getRight();
			}
		}
		return null;
			
	}
	
	
	public void add(X item) {
		Node node = new Node(item);
		if(root == null) {
			this.root = node;
			System.out.println("Root node = " + root.getItem());
			this.size++;
		}else {
			insert(this.root,node);
		}
	}
	
	private void insert(Node parent, Node child) {
		if(child.getItem().compareTo(parent.getItem()) < 0) {
			if(parent.getLeft() == null) {
				//smaller items on left so if left to parent is null
				//child can be placed on immediate left
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			}else {
				//perform recursion
				insert(parent.getLeft(),child);
			}
		}else if(child.getItem().compareTo(parent.getItem()) > 0) {
			if(parent.getRight() == null) {
				//larger items on right so if right to parent is null
				//child can be placed on immediate right
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			}else {
				//perform recursion
				insert(parent.getRight(),child);
			}
		}
		
		//if parent and child equal, do nothing
	}
	
	public boolean delete(X item) {
		boolean deleted = false;
		
		if(this.root == null) {
			return deleted;
		}
		
		//find the node to delete
		Node currentNode = getNode(item);
		if(currentNode != null) {
			if(currentNode.getLeft() == null && currentNode.getRight() == null) {
				unlink(currentNode,null);
				deleted = true;
			}
			
			else if(currentNode.getLeft() == null && currentNode.getRight() != null) {
				unlink(currentNode,currentNode.getRight());
				deleted = true;
			}
			
			else if(currentNode.getRight() == null && currentNode.getLeft() != null) {
				unlink(currentNode,currentNode.getLeft());
				deleted = true;
			}else {//node has both children, do a node swap
				//swap out the node with the right most leaf node on left side
				//We can
				Node child = currentNode.getLeft();
				while(child.getLeft()!= null && child.getRight() != null) {
					child = child.getRight();
				}
				
				//we have the right most leaf node
				//we will replace the currentNode with this node
				child.getParent().setRight(null);//remove leaf node from current position
				child.setLeft(currentNode.getLeft());
				child.setRight(currentNode.getRight());
				
				unlink(currentNode,child);
				deleted = true;
			}
		}
		if(deleted) {
			this.size--;
		}
		return deleted;
	}
	
	private void unlink(Node currentNode, Node newNode) {
		if(currentNode == this.root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			this.root = newNode;
		}else if(currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		}else {
			currentNode.getParent().setLeft(newNode);
		}
	}

	private class Node {
		private Node left;
		private Node right;
		private Node parent;
		private X item;

		public Node(X item) {
			this.left = null;
			this.right = null;
			this.parent = null;
			this.item = item;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}

	}

}
