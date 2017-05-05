/**
 * 
 */
package com.hackerearth;

import java.util.HashSet;
import java.util.Set;

/**
 * @author amahajan
 *
 * @written 25-Apr-2017
 */
public class MancunianAndFantabulousPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 2, 4 };
		firstApproach(arr);

	}

	private static void firstApproach(int[] arr) {
		Set<Integer> resultSet = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				System.out.println("{" + arr[i] + " , " + arr[j] + "}");
			}
		}

	}

}
