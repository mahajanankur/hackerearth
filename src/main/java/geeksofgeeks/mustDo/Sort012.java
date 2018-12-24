/**
 * 
 */
package geeksofgeeks.mustDo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 11-Dec-2018
 * 
 *          https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 */
public class Sort012 {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		firstApproach();

	}

	private static void firstApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		while (tests-- > 0) {
			int size = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().trim().split(" ");
			int low = 0;
			int mid = 0;
			int high = size - 1;
			String temp = null;

			while (high >= mid) {

				switch (arr[mid]) {
				case "0":
					temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp + "";
					low++;
					mid++;
					break;
				case "1":
					mid++;
					break;
				default:
					temp = arr[mid];
					arr[mid] = arr[high];
					arr[high] = temp + "";
					high--;
					break;
				}
			}

			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}

}
