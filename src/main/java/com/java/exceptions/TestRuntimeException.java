/**
 * 
 */
package com.java.exceptions;

/**
 * @author ankur.mahajan
 * @written 11-Feb-2019
 */
public class TestRuntimeException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = null;
		try {
			a.split("");
		}
		catch (Exception e) {
			System.out.println("Exception catched.");
		}

		System.out.println("Accessed");
	}

}
