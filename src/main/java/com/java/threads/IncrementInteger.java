/**
 * 
 */
package com.java.threads;

/**
 * @author ankur.mahajan
 * @written 10-Jul-2019
 */
public class IncrementInteger {

	private int counter = 0;
	private Object lock1 = new Object();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		IncrementInteger i = new IncrementInteger();
		i.test();

	}

	private void test() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					// counter++;
					synchronized (lock1) {
						counter = counter + 1;
					}

				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					// counter++;

					synchronized (lock1) {
						counter = counter + 1;
					}

				}

			}
		});
		// System.out.println("Before 1 thread Start : " +
		// System.currentTimeMillis());
		t1.start();
		// t1.join();
		// System.out.println("Before 2 thread Start : " +
		// System.currentTimeMillis());
		t2.start();
		// t2.join();
		try {
			t1.join();
			t2.join();
			// Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(counter);

	}

}
