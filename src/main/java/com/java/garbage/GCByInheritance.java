/**
 * 
 */
package com.java.garbage;

/**
 * @author ankur.mahajan
 * @written 11-Jun-2019
 */
class Parent1 {
	Long weight = 1000L;
}

public class GCByInheritance extends Parent1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GCByInheritance b = new GCByInheritance();
		GCByInheritance c = new GCByInheritance();
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
