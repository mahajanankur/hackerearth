/**
 * 
 */
package com.java.java8.inheritance;

/**
 * @author ankur.mahajan
 * @written 01-Nov-2018
 */
public class AnonymousClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b = new B() {

			@Override
			void get(long a, long b) {
				System.out.println("Anonymous class get");
			}

			@Override
			public void abstractDetails() {
				System.out.println("Anonymous class abstractDetails");

			}
		};

		b.get(10, 10);
		b.get(10);
	}

}
