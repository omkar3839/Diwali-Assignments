package com.demo.beans;

public class CircularQueue {
    int[] arr;
    int front,rear;
	public CircularQueue() {
		arr=new int[5];
		front=-1;
		rear=-1;
		
	}
	public CircularQueue(int size) {
		arr=new int[size];
		front=-1;
		rear=-1;
		
	}
	
	public boolean isFull() {
		if(front==0 && rear==arr.length-1) {
			System.out.println("queue is full");
			return true;
		}else {
			if(front==rear+1) {
				System.out.println("queue is full");
				return true;
			}
			
		}
		return false;

	}
	
	public boolean isEmpty() {
		if(front==-1) {
			System.out.println("queue is empty");
			return true;
		}
		return false;
	}
	
	public boolean enqueue(int val) {
		if(!isFull()) {
			if(front==-1) {
				front=0;
			}
		    rear=(rear+1)%arr.length;
		    arr[rear]=val;
		    System.out.println("added successfully"+val);
		    return true;
		}
		
		return false;
	}
	public int dequeue() {
		if(!isEmpty()) {
			int num=arr[front];
			//there is only one element
			if(front==rear) {
				front=-1;
				rear=-1;
			}else {
				front=(front+1)%arr.length;
			}
			return num;
			
		}
		return -1;
	}
	
    
}
