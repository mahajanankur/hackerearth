/**
 * 
 */
package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ankur.mahajan
 * @written 10-Jul-2019
 */

class Processor implements Runnable {

	private int id;

	public Processor(int workId) {
		id = workId;
	}

	@Override
	public void run() {
		System.out.println("Starting Task : " + id + ", by Thread Name : " + Thread.currentThread().getName());
		// Some processing work.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completing Task : " + id + ", by Thread Name : " + Thread.currentThread().getName());
	}

}

public class ThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// Invoke number of tasks.
		for (int i = 1; i < 6; i++) {
			pool.submit(new Processor(i));
		}

		pool.shutdown();
		System.out.println("All tasks submitted.");

		// Wait until all tasks completes. similar like join()
		// try {
		// pool.awaitTermination(1, TimeUnit.DAYS);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		System.out.println("All tasks completed.");
	}

}
