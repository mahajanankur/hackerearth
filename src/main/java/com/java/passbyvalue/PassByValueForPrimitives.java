/**
 * 
 */
package com.java.passbyvalue;

/**
 * @author amahajan
 *
 * @written 28-Jun-2017
 */
public class PassByValueForPrimitives {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		System.out.println("A is : " + a);
		checkPassByValue(a);
		System.out.println("RETURNED  : A is : " + a);
		changeValueOfObject(a);
		System.out.println("RETURNED  : A is : " + a);
	}

	private static void changeValueOfObject(int a) {
		a = 20;
	}

	private static void checkPassByValue(int a) {
		a = 30;
	}

}
