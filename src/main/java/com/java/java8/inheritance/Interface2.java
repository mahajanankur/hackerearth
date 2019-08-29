/**
 * 
 */
package com.java.java8.inheritance;

/**
 * @author amahajan
 *
 * @written 15-Mar-2017
 */
public interface Interface2 {

	void abstractDetails();

	default void defaultDetails() {
		System.out.println("defaultDetails() of Interface2");
	}

	static void staticDetails() {
		System.out.println("staticDetails() of Interface2");
	}
}
