/**
 * 
 */
package com.java.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ankur.mahajan
 * @written 10-Jul-2019
 */
public class SynchronizedBlockVsMethodKeyword {

	private Random random = new Random();

	private List<Integer> list1 = new ArrayList<Integer>();

	private List<Integer> list2 = new ArrayList<Integer>();

	private Object lock1 = new Object();

	private Object lock2 = new Object();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedBlockVsMethodKeyword obj = new SynchronizedBlockVsMethodKeyword();
		// obj.processWithoutThreads();
		obj.processWithThreads();
	}

	/**
	 * 
	 */
	private void processWithoutThreads() {
		System.out.println("Starting..");
		long start = System.currentTimeMillis();
		insertWithSynchronizedMethodKeyword();
		long end = System.currentTimeMillis();
		System.out.println("Time Taken : " + (end - start));
		System.out.println("List1 Size : " + list1.size() + " & List2 Size: " + list2.size());
	}

	/**
	 * 
	 */
	private void processWithThreads() {
		System.out.println("Starting..");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// insertWithSynchronizedMethodKeyword();
				insertWithSynBlock();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// insertWithSynchronizedMethodKeyword();
				insertWithSynBlock();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("Time Taken : " + (end - start));
		System.out.println("List1 Size : " + list1.size() + " & List2 Size: " + list2.size());
	}

	private void insertWithSynchronizedMethodKeyword() {
		for (int i = 0; i < 1000; i++) {
			addToList1();
			addToList2();
		}

	}

	private void insertWithSynBlock() {
		for (int i = 0; i < 1000; i++) {
			synchronizedBlockAddToList1();
			synchronizedBlockAddToList2();
		}

	}

	private synchronized void addToList2() {
		// Some other processing.
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// for (int i = 0; i < 1000; i++) {
		list1.add(random.nextInt(100));
		// }
	}

	private synchronized void addToList1() {
		// Some other processing.
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// for (int i = 0; i < 1000; i++) {
		list2.add(random.nextInt(100));
		// }

	}

	private void synchronizedBlockAddToList2() {

		// synchronized (this) {
		synchronized (lock1) {
			// Some other processing.
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// for (int i = 0; i < 1000; i++) {
			list1.add(random.nextInt(100));
			// }
		}

	}

	private void synchronizedBlockAddToList1() {

		// synchronized (this) {
		synchronized (lock2) {
			// Some other processing.
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// for (int i = 0; i < 1000; i++) {
			list2.add(random.nextInt(100));
			// }
		}

	}

}
