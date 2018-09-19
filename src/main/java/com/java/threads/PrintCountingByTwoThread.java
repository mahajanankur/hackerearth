/**
 * 
 */
package com.java.threads;

/**
 * @author ankur.mahajan
 * @written 06-Mar-2018
 */
public class PrintCountingByTwoThread implements Runnable {

	private int countingTill = 100;

	private static int start = 1;

	private static boolean isOdd = true;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		PrintCountingByTwoThread cls = new PrintCountingByTwoThread();
		// cls.firstApproach();
		cls.secondApproach();

	}

	private void firstApproach() throws InterruptedException {
		PrintCountingByTwoThread cls = new PrintCountingByTwoThread();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// t1.setName("Odd Thread.");
				try {
					cls.printOddNumbers();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// t2.setName("EVEN Thread!");
				try {
					cls.printEvenNumbers();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setName("ODD");
		t2.setName("EVEN");
		t1.start();
		t2.start();

	}

	private void printOddNumbers() throws InterruptedException {
		synchronized (this) {
			while (countingTill > start) {
				if (isOdd) {
					System.out.println("Inside print odd.");
					System.out.println("Thread Name : " + Thread.currentThread().getName());
					System.out.println(start);
					start++;
					isOdd = false;
					notify();
				}
				else {
					wait();
				}

			}
		}

	}

	private void printEvenNumbers() throws InterruptedException {
		synchronized (this) {
			while (countingTill > start) {
				if (!isOdd) {
					System.out.println("Inside print even.");
					System.out.println("Thread Name : " + Thread.currentThread().getName());
					System.out.println(start);
					isOdd = true;
					start++;
					notify();
				}
				else {
					wait();
				}

			}
		}

	}

	private void secondApproach() {
		Thread t1 = new Thread(new PrintCountingByTwoThread());
		Thread t2 = new Thread(new PrintCountingByTwoThread());
		t1.setName("ODD");
		t2.setName("EVEN");
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		synchronized (this) {
			while (countingTill > start) {
				if (isOdd) {
					if (Thread.currentThread().getName().equals("EVEN")) {
						try {
							wait();
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName());
					System.out.println(start);
					start++;
					isOdd = false;
					notifyAll();
				}
				else {
					if (Thread.currentThread().getName().equals("ODD")) {
						try {
							wait();
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(Thread.currentThread().getName());
					System.out.println(start);
					start++;
					isOdd = true;
					notifyAll();
				}

			}

		}

	}
}
