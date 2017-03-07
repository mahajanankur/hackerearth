package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSleep implements Runnable {

	private static final int	MYTHREADS	= 30;

	// public static void main(String[] args) {
	// // ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
	//
	// TestSleep testSleep = new TestSleep();
	// // Thread thread = new Thread(testSleep);
	// Thread thread1 = new Thread(testSleep);
	// // Thread thread2 = new Thread(testSleep);
	// thread1.start();
	// // thread2.start();
	// // executor.execute(thread);
	// }

	// public static void main(String[] args) {
	// TestSleep testSleep = new TestSleep();
	// Thread[] threads = new Thread[2];
	// for (int i = 0; i < threads.length; i++) {
	// threads[i] = new Thread(testSleep);
	// threads[i].start();
	// }
	// }

	public static void main(String[] args) {
		TestSleep testSleep = new TestSleep();
		for (int i = 1; i <= 5; i++) {
			Thread threads = new Thread(testSleep);
			threads.start();
		}
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("outside " + i);
		}

	}

}
