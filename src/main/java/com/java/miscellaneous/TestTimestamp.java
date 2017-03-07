/**
 * 
 */
package com.java.miscellaneous;

/**
 * @author amahajan
 *
 * @written Sep 23, 2016
 */
public class TestTimestamp {

	private static final long ts = 1474616852885L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long currentTimeMillis = System.currentTimeMillis();
		if (currentTimeMillis <= ts) {
			System.out.println("lower is greater");
		} else {
			System.out.println("higher is greater");
		}

	}

}
