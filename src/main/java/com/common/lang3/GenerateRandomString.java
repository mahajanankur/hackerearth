/**
 * 
 */
package com.common.lang3;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author ankur
 *
 */
public class GenerateRandomString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String prefix = "chanchal@";
		String email = prefix + RandomStringUtils.randomAlphabetic(10) + ".com";
		System.out.println(email);
	}

}
