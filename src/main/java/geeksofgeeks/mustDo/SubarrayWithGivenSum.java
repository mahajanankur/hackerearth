/**
 * 
 */
package geeksofgeeks.mustDo;

/**
 * @author ankur.mahajan
 * @written 19-Dec-2018
 */
public class SubarrayWithGivenSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 4, 20, 3, 10, 5 };
		int sum = 33;
		firstApproach(a, sum);

	}

	private static void firstApproach(int[] a, int sum) {

		for (int i = 0; i < a.length; i++) {
			int currentSum = a[i];
			for (int j = i + 1; j < a.length; j++) {

				// sub += a[j] + " ";
			}
			// System.out.println(sub);
		}

	}

}
