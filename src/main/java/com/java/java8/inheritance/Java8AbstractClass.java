/**
 * 
 */
package com.java.java8.inheritance;

import java.util.Random;

/**
 * @author ankur.mahajan
 * @written 31-May-2019
 */
public abstract class Java8AbstractClass {

	private String countryCode = "IND";

	private static String vehicle = "1743";

	private static final String state = "HP";

	public Java8AbstractClass() {

	}

	abstract void getName();

	public Long currentTime() {
		return System.currentTimeMillis();
	}

	private Long getRandom() {
		return new Random().nextLong();
	}
}
