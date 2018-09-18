/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 17-Sep-2018
 */
public class PrizeMoney {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		firstApproach();

	}

	private static void firstApproach() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfDeno = Integer.parseInt(br.readLine());
		String[] denoArray = br.readLine().split(" ");
		long[] denominations = new long[denoArray.length];
		for (int i = 0; i < denominations.length; i++) {
			denominations[i] = Long.parseLong(denoArray[i]);
		}
		Arrays.sort(denominations);
		long maxDeno = denominations[denominations.length - 1];
		long currentDeno = maxDeno + 1;
		long reminderManupulation = currentDeno;
		boolean loop = false;
		while (!loop) {
			long reminder = 0;
			for (int i = 0; i < denominations.length; i++) {
				reminder = reminderManupulation % denominations[i];
				if (reminder == 0) {
					break;
				}
				else {
					reminderManupulation = reminder;
				}
			}
			if (reminder > 0) {
				System.out.println(currentDeno);
				break;
			}
			currentDeno++;
			if (currentDeno - maxDeno == 1000) {
				System.out.println("Fake Offer!");
				loop = true;
			}
		}

	}

}
