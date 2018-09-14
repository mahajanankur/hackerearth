package geeksofgeeks.arrays;

import java.util.Arrays;

/**
 * @author ankur.mahajan
 * @written 14-Sep-2018
 */
public class RearrangeAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		int[] array = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };
		Arrays.sort(array);
		int length = array.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			if (searchNumber(array, i)) {
				result[i] = i;
			}
			else {
				result[i] = -1;
			}
			System.out.println(result[i]);
		}
	}

	private static boolean searchNumber(int[] array, int number) {
		int binarySearch = binarySearch(array, number, 0, array.length);

		return binarySearch == -1 ? false : true;
	}

	private static int binarySearch(int[] array, int number, int start, int end) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (array[middle] == number) {
				return middle;
			}
			else if (array[middle] > number) {
				return binarySearch(array, number, start, middle - 1);
			}
			else if (array[middle] < number) {
				return binarySearch(array, number, middle + 1, end);
			}
		}

		return -1;

	}

}
