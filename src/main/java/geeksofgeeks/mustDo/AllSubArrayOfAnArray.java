/**
 * 
 */
package geeksofgeeks.mustDo;

/**
 * @author ankur.mahajan
 * @written 19-Dec-2018
 */
public class AllSubArrayOfAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 4, 20, 3, 10, 5 };
		firstApproach(a);
	}

	private static void firstApproach(int[] a) {

		for (int i = 0; i < a.length; i++) {

			for (int j = i; j < a.length; j++) {

				for (int k = i; k <= j; k++) {
					System.out.print(a[k] + " ");
				}
				System.out.println();
			}

		}

	}

}
