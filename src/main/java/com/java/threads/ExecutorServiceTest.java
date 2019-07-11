/**
 * 
 */
package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ankur.mahajan
 * @written 05-Jul-2019
 */
public class ExecutorServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());

			}
		};
		es.submit(runnable);
		es.execute(runnable);
		es.shutdown();

	}

}
