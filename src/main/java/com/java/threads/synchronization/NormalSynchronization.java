/**
 * 
 */
package com.java.threads.synchronization;

/**
 * @author ankur.mahajan
 * @written 11-Jun-2019
 */
public class NormalSynchronization {

	public static void main(String[] args) {
		NormalSynchronization test = new NormalSynchronization();
		test.first();
	}

	public void first() {
		// SynchronizationTypes outer = new SynchronizationTypes();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// SynchronizationTypes outer = new SynchronizationTypes();
				// outer.normalSynchronizedMethod(1);
				SynchronizationTypes.staticSynchronizedMethod(1);
			}
		});
		t1.setName("T1");

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// SynchronizationTypes outer = new SynchronizationTypes();
				// outer.normalSynchronizedMethod(100);
				SynchronizationTypes.staticSynchronizedMethod(100);
			}
		});
		t2.setName("T2");
		t2.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
	}
}

class SynchronizationTypes {

	public synchronized void normalSynchronizedMethod(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Thread :: " + Thread.currentThread().getName() + " value :: " + (i * n));
		}
	}

	public static synchronized void staticSynchronizedMethod(int n) {
		for (int i = 1; i <= 5; i++) {
			System.out.println("Thread :: " + Thread.currentThread().getName() + " value :: " + (i * n));
		}
	}

}
