package geeksofgeeks.arrays;

import datastructure.utils.ArrayUtil;

public class ReverseAnArray {

	public static void main(String[] args) {
		String[] array = { "a", "v", "f", "g", "r", "w", "u", "b", "i", "p" };
		firstApproach(array);
	}

	private static void firstApproach(String[] array) {

		int length = array.length;
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			result[i] = array[(length - 1) - i];
		}
		System.out.println(ArrayUtil.printArray(result));
	}

}
