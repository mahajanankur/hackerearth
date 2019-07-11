/**
 * 
 */
package geeksofgeeks.arrays.matrix;

/**
 * @author ankur.mahajan
 * @written 01-Jul-2019
 */
public class BasicMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		basicMatrixCreation();

	}

	private static void basicMatrixCreation() {
		int[][] matrix1 = {{1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10}};
		// first is no of rows and second is no of columns.
		int[][] matrix2 = new int[3][4];
		matrix2[0][0] = 1;
		matrix2[0][1] = 2;
		matrix2[0][2] = 3;
		matrix2[0][3] = 4;

		matrix2[1][0] = 5;
		matrix2[1][1] = 6;
		matrix2[1][2] = 7;
		matrix2[1][3] = 8;

		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[i].length; j++) {
				System.out.println(matrix2[i][j]);
			}
		}
	}

}
