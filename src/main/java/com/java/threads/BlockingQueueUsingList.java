/**
 * 
 */
package com.java.threads;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 24-Sep-2018
 */
public class BlockingQueueUsingList implements Runnable {

	private BlockingQueue blockingQueue = new BlockingQueue();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BlockingQueueUsingList blockingQueueUsingList = new BlockingQueueUsingList();
		Thread t1 = new Thread(blockingQueueUsingList, "Main 1");
		Thread t2 = new Thread(blockingQueueUsingList, "Main 2");
		Thread t3 = new Thread(blockingQueueUsingList, "Main 3");
		Thread t4 = new Thread(blockingQueueUsingList, "Main 4");
		Thread t5 = new Thread(blockingQueueUsingList, "Main 5");
		Thread t6 = new Thread(blockingQueueUsingList, "Main 6");
		Thread t7 = new Thread(blockingQueueUsingList, "Main 7");
		Thread t8 = new Thread(blockingQueueUsingList, "Main 8");
		Thread t9 = new Thread(blockingQueueUsingList, "Main 9");
		Thread t10 = new Thread(blockingQueueUsingList, "Main 10");
		Thread t11 = new Thread(blockingQueueUsingList, "Main 11");
		Thread t12 = new Thread(blockingQueueUsingList, "Main 12");
		Thread t13 = new Thread(blockingQueueUsingList, "Main 13");
		Thread t14 = new Thread(blockingQueueUsingList, "Main 14");
		Thread t15 = new Thread(blockingQueueUsingList, "Main 15");
		Thread t16 = new Thread(blockingQueueUsingList, "Main 16");
		Thread t17 = new Thread(blockingQueueUsingList, "Main 17");
		Thread t18 = new Thread(blockingQueueUsingList, "Main 18");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		t15.start();
		t16.start();
		t17.start();
		t18.start();
	}

	@Override
	public void run() {

		if (Thread.currentThread().getName().equalsIgnoreCase("Main 16")
				|| Thread.currentThread().getName().equalsIgnoreCase("Main 17")
				|| Thread.currentThread().getName().equalsIgnoreCase("Main 18"))
			blockingQueue.dequeue();
		else
			blockingQueue.enqueue(Thread.currentThread().getName());
	}

}

class BlockingQueue {

	private List<Object> list = new ArrayList<>();

	private static final int BLOCKING_THRESHOLD = 10;

	// Similar like add.
	public synchronized void enqueue(Object o) {
		// synchronized (Thread.class) {
		 while(list.size() == BLOCKING_THRESHOLD) {
			try {
				System.out.println("Blocked adding elements as threshold reached.");
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Revoke All threads which are in waiting state.
		if (list.size() == 0) {
			notifyAll();
		}
		list.add(o);
		System.out.println("Object :" + o + " added to list current size : " + list.size());

		// }
	}

	public synchronized void dequeue() {
		// synchronized (Thread.class) {
		while (list.size() == 0) {
			System.out.println("Blocked removing elements as list is empty.");
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Revoke All threads which are in waiting state.
		if (list.size() == BLOCKING_THRESHOLD) {
			notifyAll();
		}
		list.remove(0);
		System.out.println("Object: " + list.get(0) + " is deleted from list current size : " + list.size());

		// }
	}

}
