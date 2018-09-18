/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author ankur.mahajan
 * @written 17-Sep-2018
 */
public class NthPrime {

	private static BigInteger globalFect = new BigInteger(1 + "");

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// firstApproach();
		secondApproach();

	}

	private static void secondApproach() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 2;; i++) {
			if (count == n) {
				System.out.println((i - 1));
				break;
			}
			boolean isPrime = true;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				count++;
			}

		}

	}

	private static void firstApproach() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (long i = 2;; i++) {
			if (count == n) {
				System.out.println(i - 1);
				break;
			}
			BigInteger fect = globalFect.multiply(new BigInteger(i - 1 + ""));
			globalFect = fect;
			BigInteger mod = fect.mod(new BigInteger(i + ""));
			if (mod.equals(new BigInteger(i - 1 + ""))) {
				count++;
			}
		}

	}

	/**
	 * This is used to get fectorial of a number.
	 * 
	 * @param i
	 * @param oldFect
	 * @return fectroial
	 */
	private static int getFectorial(int i, int oldFect) {
		if (i == 1) {
			return oldFect;
		}
		else {
			oldFect *= i;
			i--;
			return getFectorial(i, oldFect);
		}
	}

}
