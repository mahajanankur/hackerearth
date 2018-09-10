/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 10-Sep-2018
 */
public class PairRecovery {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		firstApproach();

	}

	private static void firstApproach() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] splitArr = input.split(" ");
		int a3 = Integer.parseInt(splitArr[0]);
		int a4 = Integer.parseInt(splitArr[1]);

		int a2 = a4 - a3;
		int a1 = a3 - a2;

		System.out.println(a1 + " " + a2);

	}

}
