/**
 * 
 */
package com.java.threads;

/**
 * @author ankur.mahajan
 * @written 20-Feb-2019
 */
public class PrintCountingByThreeThreads {

	private static final int last = 100;

	private int start = 1;

	private boolean isOdd = start % 2 == 0 ? false : true;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintCountingByThreeThreads cls = new PrintCountingByThreeThreads();
		cls.firstApproach();

	}

	private void firstApproach() {
		PrintCountingByThreeThreads cls = new PrintCountingByThreeThreads();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
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
				try {
					cls.printEvenNumbers();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		});

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					cls.printZeros();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.setName("ODD THREAD");
		t2.setName("EVEN THREAD");
		t1.start();
		t2.start();
		t3.start();
	}

	protected void printZeros() throws InterruptedException {
		// TODO Auto-generated method stub

	}

	protected void printEvenNumbers() throws InterruptedException {
		synchronized (this) {
			while (last >= start) {
				if (!isOdd) {
					System.out.println("Inside Even Thread Name : " + Thread.currentThread().getName());
					System.out.println(start++);
					isOdd = true;
					notify();
				}
				else {
					wait();
				}
			}
		}

	}

	protected void printOddNumbers() throws InterruptedException {
		synchronized (this) {
			while (last >= start) {
				if (isOdd) {
					System.out.println("Inside Odd Thread Name : " + Thread.currentThread().getName());
					System.out.println(start++);
					isOdd = false;
					notify();
				}
				else {
					wait();
				}

			}
		}

	}

}
