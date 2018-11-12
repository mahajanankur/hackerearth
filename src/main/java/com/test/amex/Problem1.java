/**
 * 
 */
package com.test.amex;

import java.util.Arrays;

import com.itextpdf.text.log.SysoCounter;

/**
 * @author ankur.mahajan
 * @written 02-Nov-2018
 */
public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {  1,1, 4, 8 };
		// int[] arr = { -7, -3, -19 };
		// Not int[] arr = { 3, 2, 3, 4 };
		// int[] arr = { 1, 3, 4, 4 };

		Arrays.sort(arr);
		boolean isFound = false;
		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] > 0 && arr[i + 1] - arr[i] > 1) {
				int res = arr[i] + 1;
				isFound = true;
				System.out.println(res);
				break;
			} else if (arr[arr.length - 1] < 0) {
				isFound = true;
				System.out.println(1);
				break;
			} else {
				continue;
			}
		}
		if (!isFound) {
			System.out.println(1);
		}
		
		/*for(int i =0; i < arr.length - 1; i++){
			
			if(arr[i] < 0 && arr[i+1] > 1){
				System.out.println(1);
				break;
			}
			
			else {
				if(arr[i] > 0){
				if((arr[i+1] - arr[i]) > 1){
					System.out.println(arr[i] +1);
					break;
				}
			}
		}
		}*/
	}

}
