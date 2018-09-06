/**
 * 
 */
package datastructure.algo.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 05-Sep-2018
 */
public class BinarySearch {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		firstApproach();

	}

	private static void firstApproach() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int search = Integer.parseInt(br.readLine());
		int[] array = { 1, 3, 6, 8, 9, 15, 19, 23 };
		int start = array.length - 1;
		int low = 0;
		int index = binarySearchAlgo(array, search, low, start);
		System.out.println(index);
	}

	private static int binarySearchAlgo(int[] array, int search, int low, int high) {
		if (low <= high) {
			int middleIndex = (low + high) / 2;
			if (array[middleIndex] == search) {
				return middleIndex;
			}
			if (array[middleIndex] > search) {
				return binarySearchAlgo(array, search, low, middleIndex - 1);
			}
			else if (array[middleIndex] < search) {
				return binarySearchAlgo(array, search, middleIndex + 1, high);
			}
		}
		return -1;

	}

}
