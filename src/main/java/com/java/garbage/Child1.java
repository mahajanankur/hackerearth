/**
 * 
 */
package com.java.garbage;

/**
 * @author ankur.mahajan
 * @written 11-Jun-2019
 */
public class Child1 extends Parent {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Child1 b = new Child1();
		Child1 c = new Child1();
		// System.out.println("Check");
		b = null;
		c = null;// going to gc.
		System.gc();
	}

	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
		// System.out.println(10 / 0);
	}

}
