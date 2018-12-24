/**
 * 
 */
package geeksofgeeks.arrays;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @author ankur.mahajan
 * @written 12-Dec-2018
 * 
 *          https://www.geeksforgeeks.org/find-the-element-having-different-frequency-than-other-array-elements/
 */
public class DifferentFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {1, 1, 2, 2, 3};
		// firstApproach(arr);
		secondApproach(arr);

	}

	private static void secondApproach(int[] arr) {
		Hashtable<Integer, Integer> table = new Hashtable<>();
		for (int i = 0; i < arr.length; i++) {
			Integer value = table.get(arr[i]);
			if (null != value) {
				value++;
				table.put(arr[i], value);
			} else {
				table.put(arr[i], 1);
			}
		}

		int loop = 0;
		int lastValue = 0;
		for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
			if (loop == 0) {
				lastValue = entry.getValue();
				loop++;
				continue;
			}
			int value = entry.getValue();
			if (value != lastValue) {

				System.out.println("Different frequency number: " + entry.getKey());
				break;
			}
			loop++;
		}
	}

	private static void firstApproach(int[] arr) {
		int currentFreq = 0;
		int previousFreq = 0;
		int oldNumber = 0;

		for (int i = 0; i < arr.length; i++) {
			int currentNumber = arr[i];
			if (oldNumber != currentNumber) {
				previousFreq = currentFreq;
				currentFreq = 1;
				oldNumber = currentNumber;
			} else {
				currentFreq++;
				// oldNumber = currentNumber;
			}

		}

	}

}
