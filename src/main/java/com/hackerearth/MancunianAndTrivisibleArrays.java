/**
 * 
 */
package com.hackerearth;

import java.util.Arrays;
import java.util.List;

/**
 * @author amahajan
 *
 * @written 25-Apr-2017
 */
public class MancunianAndTrivisibleArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "3 5 -6";
		String[] split = str.split(" ");
		List<String> list = Arrays.asList(split);
		// int[] arr = { 3, 5, -6 };
		firstApproach(list);

	}

	private static void firstApproach(List<String> list) {
		long sum = 0;
		for (String str : list) {
			sum += Long.parseLong(str);
		}

		int reminder = (int) (sum % 3);
		// int indexOf = list.indexOf(reminder + "");
		if (list.indexOf(reminder + "") != -1) {
			System.out.println("1");
		}

	}

}
