/**
 * 
 */
package com.java.arithmetic;

/**
 * @author ankur.mahajan
 * @written 15-Mar-2019
 */
public class BitShifting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bitShift();

	}

	private static void bitShift() {
		int a = 15; // 1111
		System.out.println("A To Binary : " + Integer.toBinaryString(a));
		int b = 4;
		System.out.println("B To Binary : " + Integer.toBinaryString(b));
		int leftShift = a << b;
		System.out.println(
				"After left shift the result is : " + leftShift + " and to binary : " + Integer.toBinaryString(leftShift));
		int rightShift = a >> b;
		System.out.println(
				"After right shift the result is : " + rightShift + " and to binary : " + Integer.toBinaryString(rightShift));
	}

}
