package com.demo.test;

import com.demo.beans.CircularQueue;

public class CircularQueueTest {
    public static void main(String[] args) {
    	CircularQueue ob=new CircularQueue();
    	ob.enqueue(10);
    	ob.enqueue(20);
    	ob.enqueue(30);
    	ob.enqueue(35);
    	ob.enqueue(38);
    	ob.enqueue(100);
    	
    	System.out.println("dequeue" +ob.dequeue());
    	//added
    	ob.enqueue(100);
    	//queue is full
    	ob.enqueue(200);
    	
    	System.out.println("dequeue" +ob.dequeue());
    	System.out.println("dequeue" +ob.dequeue());
    	ob.enqueue(111);
    	ob.enqueue(222);
    	ob.enqueue(200);
    	while(!ob.isEmpty()) {
    		System.out.print("dequeue" +ob.dequeue()+",");
    	}
    	System.out.println();
    }
}


