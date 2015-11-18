package geeksofgeeks.arrays;

import java.util.Arrays;

import datastructure.utils.ArrayUtil;

public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] first = { 12, 11, 15, 10, 20 };
		int[] second = new int[] { 10, 11, 12, 15, 20 };

		firstApproach(first, second);
	}

	private static void firstApproach(int[] first, int[] second) {
		int mergeLen = first.length + second.length;
		Integer[] mergeArr = new Integer[mergeLen];
		int j = 0;
		for (int i = 0; i < mergeLen; i++) {
			if (i < first.length) {
				mergeArr[i] = first[i];
			}
			else {
				mergeArr[i] = second[j];
				j++;
			}
		}
		Arrays.sort(mergeArr);
		System.out.println(ArrayUtil.printArray(mergeArr));
		int firstMedian = mergeArr[(mergeLen / 2) - 1];
		int secondMedian = mergeArr[mergeLen / 2];
		int finalMedian = (firstMedian + secondMedian) / 2;
		System.out.println(finalMedian);
	}

}
