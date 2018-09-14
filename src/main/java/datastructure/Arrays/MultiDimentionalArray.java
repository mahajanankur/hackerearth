/**
 * 
 */
package datastructure.Arrays;

/**
 * @author ankur.mahajan
 * @written 13-Sep-2018
 */
public class MultiDimentionalArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declare 2D array
		// In this array 3 rows and 4 columns are there matrix having (3X4)
		int[][] arr1 = new int[3][4];
		arr1[0][0] = 10;
		arr1[0][1] = 11;
		arr1[0][2] = 12;
		arr1[0][3] = 13;
		System.out.println("Number of rows: " + arr1.length);
		System.out.println("Number of columns : " + arr1[0].length);
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i][i]);
			// System.out.println(arr1[i]);
		}

	}

}
