/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 08-Oct-2018
 */
public class AliHelpingInnocentPeople {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char alpha = str.charAt(2);
		boolean isValid = true;
		if (alpha == 'A' || alpha == 'E' || alpha == 'I' || alpha == 'O' || alpha == 'U' || alpha == 'Y') {
			System.out.println("invalid");
			isValid = false;
		} else {
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length - 1; i++) {
				if (i == 1 || i == 2 || i == 5 || i == 6) {
					continue;
				}
				int first = Integer.parseInt(charArray[i] + "");
				int second = Integer.parseInt(charArray[i + 1] + "");
				int sum = first + second;
				boolean state = sum % 2 == 0 ? false : true;
				if (state) {
					System.out.println("invalid");
					isValid = false;
					break;
				}
			}

		}
		if (isValid) {
			System.out.println("valid");
		}

	}

}
