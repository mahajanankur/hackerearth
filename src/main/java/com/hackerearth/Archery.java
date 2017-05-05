/**
 * 
 */
package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author amahajan
 *
 * @written 02-May-2017
 */
public class Archery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		finalApproach();

	}

	private static void finalApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testC = Integer.parseInt(br.readLine());
			if (testC > 0 && testC <= 5) {
				long[] resultArray = new long[testC];
				int loop = 0;
				while (testC > loop) {
					int numberLength = Integer.parseInt(br.readLine());
					String[] numbers = br.readLine().split(" ");
					long lcm = calculateLCM(numbers);
					resultArray[loop] = lcm;
					loop++;
				}
				for (int i = 0; i < resultArray.length; i++) {
					System.out.println(resultArray[i]);
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void firstApproach() {
		int[] numbers = { 2, 3, 4 };
		calculateLCM(numbers.length, numbers);

	}

	// lcm(a1, a2, a3) = lcm(lcm(a1, a2), a3)
	// lcm(a, b) = a * b/gcd(a,b)
	private static long calculateLCM(int size, int... numbers) {
		long result = 1;
		for (int i = 0; i < size; i++) {
			result = result * numbers[i] / calculateGCM(result, numbers[i]);
		}
		return result;
	}

	private static long calculateLCM(String... numbers) {
		long result = 1;
		for (int i = 0; i < numbers.length; i++) {
			int number = Integer.parseInt(numbers[i]);
			result = result * number / calculateGCM(result, number);
		}
		return result;
	}

	private static long calculateGCM(long a, long b) {
		if (b == 0) {
			return a;
		}
		return calculateGCM(b, a % b);
	}

}
