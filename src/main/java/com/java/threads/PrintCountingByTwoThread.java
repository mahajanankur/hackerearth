/**
 * 
 */
package com.java.threads;

import com.itextpdf.text.log.SysoCounter;

/**
 * @author ankur.mahajan
 * @written 06-Mar-2018
 */
public class PrintCountingByTwoThread implements Runnable{

	private int countingTill = 100;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		PrintCountingByTwoThread cls = new PrintCountingByTwoThread();
		cls.firstApproach();

	}

	private void firstApproach() throws InterruptedException {
		PrintCountingByTwoThread cls = new PrintCountingByTwoThread();
		Thread t1 = new Thread(cls);
		t1.start();
		t1.join();
		Thread t2 = new Thread(cls);
		t2.start();
		t2.join();

	}

	@Override
	public void run() {
		System.out.println("Hey");
		for (int i = 1; i < countingTill; i++) {
			System.out.println(i);
		}

	}

}
