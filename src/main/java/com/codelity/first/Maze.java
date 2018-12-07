/**
 * 
 */
package com.codelity.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 06-Dec-2018
 */
public class Maze {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		febonaciSeries();
//		for (String s : args) {
//			System.out.println(s.trim());
//		}
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String readLine1 = br.readLine();
//		System.out.println(readLine1 + " Mahajan");
//		String readLine2 = br.readLine();
//		char[] charArray = readLine2.toCharArray();
//		String ulta = "";
//		for (int i = 0; i < charArray.length; i++) {
//			ulta = ulta + charArray[charArray.length - 1 - i];
//		}
//		System.out.println(ulta);

	}

	// 1, 1 ,2 ,3,5,8,13,

	private static void febonaciSeries() {
		int next = 1, prev = 1, sum = 0;
		while (prev < 100) {
			sum = next + prev;
			System.out.println(prev);
			prev = next;
			next = sum;
		}

	}

}
