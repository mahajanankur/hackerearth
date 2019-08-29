/**
 * 
 */
package com.java.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ankur.mahajan
 * @written 11-Jul-2019
 * 
 * 
 *          A CyclicBarrier is a reusable construct where a group of threads
 *          waits together until all of the threads arrive. At that point, the
 *          barrier is broken and an action can optionally be taken.
 * 
 *          We can think of this like a group of friends. Every time they plan
 *          to eat at a restaurant they decide a common point where they can
 *          meet. They wait for each other there, and only when everyone arrives
 *          can they go to the restaurant to eat together.
 */

class Guests implements Runnable {

	private CyclicBarrier barrier;

	private int personId;

	public Guests(CyclicBarrier barrier, int personId) {
		this.barrier = barrier;
		this.personId = personId;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println("Person : " + personId + " has reached the hotel reception.");
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		//System.out.println("Person : " + personId + " WAITING OVER!!!");

	}

}

public class CyclicBarrierTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(5, () -> {
			System.out.println("All guests reached at hotel, let eat together!!");
		});

		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 1; i < 6; i++) {
			Thread.sleep(3000);
			pool.submit(new Guests(barrier, i));
		}

		pool.shutdown();
		pool.awaitTermination(5, TimeUnit.MINUTES);
		System.out.println("All tasks done!!");
	}

}
