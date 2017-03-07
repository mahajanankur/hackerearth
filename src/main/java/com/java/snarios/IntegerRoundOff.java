/**
 * 
 */
package com.java.snarios;

/**
 * @author amahajan
 *
 */
public class IntegerRoundOff {

	public static void main(String[] args) {
		double a = 10;
		double b = 76;
		double res = (a * b) / 100;
		// int c = Math.round((a * b) / 100);
		double d = (a * b) / 100;
		// Integer e = new Integer((a * b) / 100);
		// System.out.println(e);

		double f = 2.6;
		long round = Math.round(res);
		System.out.println(round);
	}

}
