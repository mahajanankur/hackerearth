package geeksofgeeks.arrays;

import java.util.Arrays;

public class MergeTwoArrays {

	public static void main(String[] args) {
		int[] m = { 2, 8, 13, 15, 20 };
		int[] n = new int[] { 5, 7, 9, 25 };

		firstApproach(m, n);

	}

	private static void firstApproach(int[] m, int[] n) {
		int mergeLength = n.length + m.length;
		int[] merge = new int[mergeLength];
		int j = 0;
		for (int i = 0; i < mergeLength; i++) {
			if (i < m.length) {
				merge[i] = m[i];
			}
			else {
				merge[i] = n[j];
				j++;
			}
		}
		Arrays.sort(merge);
		System.out.println(Arrays.toString(merge));
	}
}
