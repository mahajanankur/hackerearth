package geeksofgeeks.arrays;


/**
 * @author ankur
 *
 */
/**
 * @author ankur
 * 
 */
public class NumberOccurringOddNumberOfTimes {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		firstApproach(arr);
		secondApproach(arr);

	}

	/**
	 * The Best Solution is to do bitwise XOR of all the elements. XOR of all
	 * elements gives us odd occurring element. Please note that XOR of two
	 * elements is 0 if both elements are same and XOR of a number x with 0 is
	 * x.
	 * 
	 * Time Complexity O(n)
	 * 
	 * @param arr
	 */
	private static void secondApproach(int[] arr) {
		int xor = 0;
		for (int i = 0; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}
		System.out.println("Number occuring odd number of times : " + xor);

	}

	/**
	 * Time Complexity O(n*n)
	 * 
	 * @param arr
	 */
	private static void firstApproach(int[] arr) {
		String result = null;
		for (int i = 0; i < arr.length; i++) {
			int counter = 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					counter++;
				}
			}
			if (counter % 2 != 0) {
				result = arr[i] + "";
				break;
			}
		}
		System.out.println("Number occuring odd number of times : " + result);
	}
}
