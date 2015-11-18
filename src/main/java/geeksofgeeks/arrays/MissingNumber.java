package geeksofgeeks.arrays;

import java.util.Arrays;

public class MissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 6, 3, 7, 8 };
		firstApproach(arr);
		secondApproach(arr);

	}

	/**
	 * By Series sum. More efficient than first.
	 * 
	 * @param arr
	 */
	private static void secondApproach(int[] arr) {

		int n = arr.length + 1;
		// total sum of the series.
		int sum = (n * (n + 1)) / 2;
		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {
			arrSum += arr[i];
		}
		int missing = sum - arrSum;
		System.out.println(missing);

	}

	/**
	 * This approach is by implementing sort method, which will increase the
	 * complexity.
	 * 
	 * @param arr
	 */
	private static void firstApproach(int[] arr) {
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int first = arr[i];
			int second = arr[i + 1];

			if (second - first != 1) {
				System.out.println(first + 1);
				break;
			}
		}
	}

}
