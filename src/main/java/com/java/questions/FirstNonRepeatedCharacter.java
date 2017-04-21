/**
 * 
 */
package com.java.questions;

/**
 * @author amahajan
 *
 * @written 20-Apr-2017
 */
public class FirstNonRepeatedCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach("teeter");

	}

	private static void firstApproach(String str) {
		char[] charArray = str.toCharArray();
		for (char c : charArray) {
			if (str.indexOf(c) == str.lastIndexOf(c)) {
				System.out.println(c);
				break;
			}
		}

	}

}
