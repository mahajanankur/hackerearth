/**
 * 
 */
package com.java.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ankur.mahajan
 * @written 11-Jul-2019
 * 
 * 
 *          A CountDownLatch is a construct that a thread waits on while other
 *          threads count down on the latch until it reaches zero.
 * 
 *          We can think of this like a dish at a restaurant that is being
 *          prepared. No matter which cook prepares however many of the n items,
 *          the waiter must wait until all the items are on the plate. If a
 *          plate takes n items, any cook will count down on the latch for each
 *          item she puts on the plate.
 */

class Processor1 implements Runnable {

	private CountDownLatch latch;

	public Processor1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Starting");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();

		System.out.println("Completed");
	}

}

public class CountdownLatchTest {

	CountDownLatch latch = new CountDownLatch(7);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(7);
		ExecutorService pool = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 20; i++) {
			pool.submit(() -> {
				long prev = countDownLatch.getCount();
				System.out.println("Prev count : " + prev);
				countDownLatch.countDown();
				if (countDownLatch.getCount() != prev) {
					System.out.println("Count Updated");
				}
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
		// CountdownLatchTest test = new CountdownLatchTest();
		// test.invoke();
	}

	private void invoke() {
		ExecutorService pool = Executors.newFixedThreadPool(2);

		for (int i = 1; i < 6; i++) {
			pool.submit(new Processor1(latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		pool.shutdown();
	}

}
