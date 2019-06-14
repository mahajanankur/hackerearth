/**
 * 
 */
package com.java.threads.synchronization;

import java.util.Random;

/**
 * @author ankur.mahajan
 * @written 13-Jun-2019
 */
class Processor {

	private int size = 10;

	private Integer[] arr = new Integer[size];

	private int current = 0;

	public void produce() throws InterruptedException {
		synchronized (this) {
			while (current == size - 1) {
				System.out.println("Blocked adding as threshold reached.");
				wait();
			}
			if (current < size - 1) {
				notify();
			}

			int generateRandom = generateRandom();
			arr[current++] = generateRandom;
			System.out.println("Produced.." + generateRandom);

		}
	}

	public void consume() throws InterruptedException {
		// DO somthing
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Consuming..");
			while (current == 0) {
				System.out.println("Array is empty.");
				wait();
			}

			int res = arr[--current];
			System.out.println("Retrurning " + res);
			notify();

		}

	}

	private int generateRandom() {
		Random random = new Random();
		return random.nextInt(100);
	}
}

public class ProducerConsumerByArray {

	private static Processor processor = new Processor();

	public static void main(String[] args) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						processor.produce();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						processor.consume();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		t1.start();
		t2.start();
		// try {
		// t1.join();
		// t2.join();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
	}

}
