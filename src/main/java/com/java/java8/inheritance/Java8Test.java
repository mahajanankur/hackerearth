/**
 * 
 */
package com.java.java8.inheritance;

/**
 * @author ankur.mahajan
 * @written 31-May-2019
 */
public class Java8Test implements Java8Interface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Java8Test cls = new Java8Test();
		cls.testReferences();
	}

	void testReferences() {
		Java8Test cls = new Java8Test();
		System.out.println("CLass refernce : " + cls.getTime());
		Java8Interface inter = new Java8Test();
		System.out.println("Interface refernce : " + inter.getTime());
		Long time = Java8Interface.super.getTime();
		System.out.println("Default call : " + time);
		// Static method

		Java8Interface inter1 = new Java8Test();
		// compile time error :: as through interface ref its a static method
		// not bound to an object.
		// System.out.println("Interface refernce : " + inter1.getRandom());
		System.out.println("Static by class refernce : " + cls.getRandom());
		Long rand = Java8Interface.getRandom();
		System.out.println("Static direct call : " + rand);
	}

	// Overidden Default method of interface.
	public Long getTime() {
		return 1000L;

	}

	public Long getRandom() {
		return 9898L;

	}

	@Override
	public void getName() {
		System.out.println("Ankur");

	}

}
