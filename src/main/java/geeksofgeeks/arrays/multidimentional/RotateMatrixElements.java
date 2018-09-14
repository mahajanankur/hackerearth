/**
 * 
 */
package geeksofgeeks.arrays.multidimentional;

/**
 * @author ankur.mahajan
 * @written 13-Sep-2018
 */
public class RotateMatrixElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		int[][] inputArray = { { 1, 3, 4, 6 }, { 4, 6, 1, 3 }, { 4, 9, 80, 67 }, { 65, 9, 67, 54, 3 }, { 56, 34, 0, 12 } };
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[i].length; j++) {
				System.out.println(inputArray[i][j]);
			}

		}
	}

}
