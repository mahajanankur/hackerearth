/**
 * 
 */
package com.java.java8.inheritance;

import java.util.Random;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

/**
 * @author ankur.mahajan
 * @written 31-May-2019
 * 
 *          1. No private modifier 
 *          2. No constructor 
 *          3. only default and static methods
 */
public interface Java8Interface {

	// private static final String state = "HP";

	public String countryCode1 = "IND";

	public static String vehicle1 = "1743";

	public static final String state1 = "HP";

	void getName();

	default Long getTime() {
		return System.currentTimeMillis();
	}

	static Long getRandom() {
		return new Random().nextLong();
	}

}
