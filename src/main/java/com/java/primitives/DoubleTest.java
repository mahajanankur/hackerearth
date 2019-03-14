/**
 * 
 */
package com.java.primitives;

/**
 * @author ankur.mahajan
 * @written 22-Feb-2019
 */
public class DoubleTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		int a = 18;
		int b = 8;

		double c = a / b;
		double d = (double) a / b;

		System.out.println("c is = " + c);
		System.out.println("d is = " + d);

	}

}
