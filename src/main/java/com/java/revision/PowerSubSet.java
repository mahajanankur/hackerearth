/**
 * 
 */
package com.java.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amahajan
 * 
 */
public class PowerSubSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		System.out.println("Please enter the string below:\n");
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (str != null && !str.equals("")) {
			powerSubSetOfAString(str);
			subStringsOfAString(str);
		} else {
			System.out.println("Bad format.");
		}
	}

	private static void subStringsOfAString(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j < str.length(); j++) {
				String substring = str.substring(i, j);
				builder.append("{").append(substring).append("},");
			}
		}
		System.out.println("Sub Strings : " + builder);
	}

	private static void powerSubSetOfAString(String str) {
		StringBuilder result = new StringBuilder();

		int length = str.length();
		int powerSetLength = (int) Math.pow(2, length);

		for (int i = 0; i < powerSetLength; i++) {
			StringBuilder inner = new StringBuilder();
			String binary = intToBinary(i, length);

			for (int j = 0; j < binary.length(); j++) {
				if (binary.charAt(j) == '1') {
					char c = str.charAt(j);
					inner.append(c);
				}
			}
			result.append("{").append(inner).append("},");
		}
		System.out.println("Power Sub-Sets : " + result);
	}

	private static String intToBinary(int i, int length) {
		String binary = Integer.toBinaryString(i);
		while (binary.length() < length) {
			binary = '0' + binary;
		}
		return binary;
	}

}
