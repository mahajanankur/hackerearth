/**
 * 
 */
package datastructure.algo.sorting;

/**
 * @author ankur.mahajan
 * @written 05-Sep-2018
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 24, 1, 78, 65, 3, 9, 67, 43 };
		int[] sortedArray = firstApproach(array);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}

	}

	private static int[] firstApproach(int[] array) {
		// int[] sortedArray = new int[array.length];
		int minimum = 0;
		for (int i = 0; i < array.length; i++) {
			int minIndex = i;
			minimum = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (minimum > array[j]) {
					minimum = array[j];
					minIndex = j;
				}
			}
			array[minIndex] = array[i];
			array[i] = minimum;
		}
		return array;
	}

}
