package geeksofgeeks.arrays;

import datastructure.utils.ArrayUtil;

public class ArrayRotation {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7 };
		int rotationIndex = 6;
		int arrayLenght = array.length;
		firstApproach(array, rotationIndex, arrayLenght);

	}

	private static void firstApproach(int[] array, int rotationIndex,
			int arrayLenght) {
		Integer[] result = new Integer[arrayLenght];
		int j = 0;
		for (int i = 0; i < arrayLenght; i++) {
			int temp = i + rotationIndex;
			if (temp < arrayLenght) {
				result[i] = array[temp];
			}
			else {
				result[i] = array[j];
				j++;
			}

		}
		System.out.println(ArrayUtil.printArray(result));
	}

}
