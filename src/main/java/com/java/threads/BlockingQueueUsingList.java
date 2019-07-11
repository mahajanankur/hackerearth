/**
 * 
 */
package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ankur.mahajan
 * @written 24-Sep-2018
 */
public class BlockingQueueUsingList implements Runnable {

	private BlockingQueue blockingQueue = new BlockingQueue();

	// private volatile static int loop = 0;
	private volatile static AtomicInteger loop = new AtomicInteger();

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// byNormalThreadClass();
		byExecutorService();
	}

	private static void byExecutorService() throws InterruptedException {
		BlockingQueueUsingList bq = new BlockingQueueUsingList();
		ExecutorService es = Executors.newFixedThreadPool(4);
		while (loop.incrementAndGet() < 50) {
			es.submit(bq);
		}
		// es.submit(bq);
		// es.execute(bq);
		// Thread.sleep(2000);
		es.shutdown();

	}

	private static void byNormalThreadClass() {
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

	// @Override
	// public void run() {
	// try {
	// if (Thread.currentThread().getName().equalsIgnoreCase("Main 16")
	// || Thread.currentThread().getName().equalsIgnoreCase("Main 17")
	// || Thread.currentThread().getName().equalsIgnoreCase("Main 18"))
	// blockingQueue.dequeue();
	// else
	// blockingQueue.enqueue(Thread.currentThread().getName());
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }

	@Override
	public void run() {
		try {
			// System.out.println("COUNT:: " + loop);
			if (loop.incrementAndGet() % 6 == 0) {
				Thread.sleep(1000);
				blockingQueue.dequeue();
			} else {
				blockingQueue.enqueue(Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class BlockingQueue {

	private volatile List<Object> list = new ArrayList<>();

	private static final int BLOCKING_THRESHOLD = 10;

	// Similar like add.
	public synchronized void enqueue(Object o) throws InterruptedException {
		// synchronized (Thread.class) {
		while (list.size() == BLOCKING_THRESHOLD) {
			System.out.println("Blocked adding elements as threshold reached.");
			wait();
		}
		// Revoke All threads which are in waiting state.
		if (list.size() == 0) {
			notifyAll();
		}
		// Thread.sleep(2000);
		list.add(o);
		System.out.println("Object :" + o + " added to list current size : " + list.size());

		// }
	}

	public synchronized void dequeue() throws InterruptedException {
		// synchronized (Thread.class) {
		while (list.size() == 0) {
			System.out.println("Blocked removing elements as list is empty.");
			wait();
		}
		// Revoke All threads which are in waiting state.
		if (list.size() == BLOCKING_THRESHOLD) {
			notifyAll();
		}
		list.remove(0);
		System.out.println("Object: " + list.get(0) + " is deleted from list current size : " + list.size());
		// Thread.sleep(2000);
		// }
	}

}
