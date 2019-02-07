/**
 * 
 */
package geeksofgeeks.mustDo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 18-Jan-2019
 */
public class EquilibriumIndexArray {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = { 20, 17, 42, 25, 32, 32, 30, 32, 37, 9, 2, 33, 31, 17, 14, 40, 9, 12, 36, 21, 8, 33, 6, 6, 10, 37, 12, 26,
				21, 3 };
		firstApproach(arr);
		secondApproach(arr);
		submission();

	}

	private static void submission() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while (tc > 0) {
			boolean isFound = false;
			int length = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			long sum = 0;
			long leftSum = 0;
			for (int i = 0; i < length; i++) {
				sum += Integer.parseInt(arr[i]);
			}

			for (int j = 0; j < length; j++) {
				sum -= Integer.parseInt(arr[j]);
				// If leftSum is equal to sum, then return current index.
				if (leftSum == sum) {
					System.out.println(j + 1);
					isFound = true;
					break;

				}
				// update leftSum for next iteration.
				leftSum += Integer.parseInt(arr[j]);
			}
			if (!isFound) {
				System.out.println(-1);
			}
			tc--;
		}
	}

	private static int secondApproach(int[] arr) {
		long sum = 0;
		long leftSum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		for (int j = 0; j < arr.length; j++) {
			sum -= arr[j];
			// If leftSum is equal to sum, then return current index.
			if (leftSum == sum) {
				return j;
			}
			// update leftSum for next iteration.
			leftSum += arr[j];
		}
		return -1;
	}

	private static void firstApproach(int[] arr) {
		boolean isFound = false;
		for (int i = 0; i < arr.length; i++) {
			long leftSum = 0, rightSum = 0;
			// Get the sum of left sub array
			for (int j = 0; j < i; j++) {
				leftSum += arr[j];
			}

			// Get the sum of right sub array
			for (int k = i + 1; k < arr.length; k++) {
				rightSum += arr[k];
			}

			if (leftSum == rightSum) {
				System.out.println("Equilibrium Index where sums are equal : " + i);
				isFound = true;
				break;
			}
		}
		if (!isFound) {
			System.out.println("No equilibrium index found.");
		}

	}

}
