/**
 * 
 */
package com.java.wideningVSautoboxing;

/**
 * @author ankur.mahajan
 * @written 03-Jun-2019
 */
public class WideningVsAutoboxing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		testWideningVsAutoboxing(a);

	}

	// private static void testWideningVsAutoboxing(int a) {
	// System.out.println("Exact");
	//
	// }

	// - Widening v/s Autoboxing : Widening wins
	private static void testWideningVsAutoboxing(long a) {
		System.out.println("Widening");

	}

	// - Widening plus Autoboxing : Compile time error
	private static void testWideningVsAutoboxing(Long a) {
		System.out.println("Autoboxing");

	}

}
