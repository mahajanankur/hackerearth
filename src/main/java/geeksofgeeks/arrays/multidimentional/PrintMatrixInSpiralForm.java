/**
 * 
 */
package geeksofgeeks.arrays.multidimentional;

/**
 * @author ankur.mahajan
 * @written 13-Sep-2018
 */
public class PrintMatrixInSpiralForm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
		// int R = 3;
		// int C = 6;
		// int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13,
		// 14, 15, 16, 17, 18 } };
		// spiralPrint(R, C, a);
	}

	private static void firstApproach() {
		int[][] inputArray = { { 1, 3, 4, 6 }, { 4, 6, 1, 3 }, { 4, 9, 80, 67 }, { 65, 9, 67, 54 }, { 56, 34, 0, 12 } };
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray[i].length; j++) {
				System.out.print(inputArray[i][j] + "\t");
			}
			// System.out.println("\n");
			System.out.println();
		}
		System.out.println("\n");
		int startRow = 0, startColumn = 0;
		int lastRow = inputArray.length;
		int lastColumn = inputArray[0].length;

		for (int i = startColumn; i < lastColumn; i++) {
			System.out.print(inputArray[startRow][i] + " ");
		}
		startRow++;
		for (int i = startRow; i < lastColumn; i++) {
			System.out.print(inputArray[i][lastColumn - 1] + " ");
		}
		lastColumn--;

		for (int i = lastColumn; i >= startColumn - 1; i--) {
			System.out.print(inputArray[lastRow][i] + " ");
		}
		lastRow--;

		for (int i = lastRow; i >= startColumn; i--) {
			System.out.println(inputArray[i][startColumn]);
		}
	}

	// Function print matrix in spiral form
	static void spiralPrint(int m, int n, int a[][]) {
		int i, k = 0, l = 0;
		/*
		 * k - starting row index
		 * m - ending row index
		 * l - starting column index
		 * n - ending column index
		 * i - iterator
		 */

		while (k < m && l < n) {
			// Print the first row from the remaining rows
			for (i = l; i < n; ++i) {
				System.out.print(a[k][i] + " ");
			}
			k++;

			// Print the last column from the remaining columns
			for (i = k; i < m; ++i) {
				System.out.print(a[i][n - 1] + " ");
			}
			n--;

			// Print the last row from the remaining rows */
			if (k < m) {
				for (i = n - 1; i >= l; --i) {
					System.out.print(a[m - 1][i] + " ");
				}
				m--;
			}

			// Print the first column from the remaining columns */
			if (l < n) {
				for (i = m - 1; i >= k; --i) {
					System.out.print(a[i][l] + " ");
				}
				l++;
			}
		}
	}
}