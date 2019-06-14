/**
 * 
 */
package com.java.wideningVSautoboxing;

/**
 * @author ankur.mahajan
 * @written 13-Jun-2019
 */
public class ObjectCalling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectCalling obj = new ObjectCalling();
		obj.getName(null);
		// obj.getName1(null);

	}

	public void getName(String name) {
		System.out.println("String");
	}

	public void getName(Object name) {
		System.out.println("Object");
	}

	// Compile time error.
	// public void getName(char[] name) {
	// System.out.println("Char[]");
	// }

	// public void getName1(char[] name) {
	// System.out.println("Char[]");
	// }

}
