/**
 * 
 */
package com.java.questions;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author amahajan
 *
 * @written 25-Apr-2017
 */
public class PowerSubSetsOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4 };
		firstApproach(arr);

	}

	private static void firstApproach(int[] arr) {
		// get all the power subsets of the array.
		Set<Set<String>> powerSet = new HashSet<>();
		int length = arr.length;
		int numberOfSets = (int) Math.pow(2, length);

		for (int i = 0; i < numberOfSets; i++) {
			// convert to binary format
			String binary = Integer.toBinaryString(i);
			while (binary.length() < length) {
				binary = "0" + binary;
			}
			Set<String> innerSet = new LinkedHashSet<>();
			for (int j = 0; j < binary.length(); j++) {
				if (binary.charAt(j) == '1') {
					innerSet.add(arr[j] + "");
				}
			}
			powerSet.add(innerSet);
		}
		System.out.println(powerSet);

	}

}
