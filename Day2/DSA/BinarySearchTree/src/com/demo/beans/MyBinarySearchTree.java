package com.demo.beans;

public class MyBinarySearchTree {
	Node root;
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int value) {
			this.data=value;
			this.left=null;
			this.right=null;
		}
	}
	public MyBinarySearchTree() {
		root=null;
	}
	
	public void insertNode(int key) {
		root=insertData(root,key);
	}

	private Node insertData(Node root, int key) {
		Node newNode=new Node(key);
		if(root==null) {
			root=newNode;
			return root;
		}else {
			if(key<root.data) {
				root.left=insertData(root.left,  key);
			}else {
				root.right=insertData(root.right,key);
			}
			return root;
		}
		
	}
	
	public void inorder() {
		inorderTraversal(root);
		System.out.println();
	}

	private void inorderTraversal(Node root) {
		if(root!=null) {
			inorderTraversal(root.left);
			System.out.print(root.data+",");
			inorderTraversal(root.right);
		}
		
	}
	
	public void preorder() {
		preorderTraversal(root);
		System.out.println();
	}

	private void preorderTraversal(Node root) {
		if(root!=null) {
			System.out.print(root.data+",");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		
	}
	
	public void postorder() {
		postorderTraversal(root);
		System.out.println();
	}

	private void postorderTraversal(Node root) {
		if(root!=null) {
			
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data+",");
		}
		
	}
	
	
	
	
	
}
