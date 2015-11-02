package geeksofgeeks.arrays;

public class LargestSumContiguousSubarray {

	public static void main(String[] args) {

		int[] arr = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		// firstApproach(arr);
		secondApproach(arr);
	}

	private static void secondApproach(int[] arr) {
		int maxEndingFront = 0, maxEndingEnd = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingFront += arr[i];
			if (maxEndingFront < 0) {
				maxEndingFront = 0;
			}
			if (maxEndingEnd < maxEndingFront) {
				maxEndingEnd = maxEndingFront;
			}
		}
		System.out.println(maxEndingEnd);
	}

	private static void firstApproach(int[] arr) {

		String subString = null;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i + 1; j < arr.length; j++) {
				subString += arr[i] + ", " + arr[j];
				// sum += arr[i]
			}
		}
		System.out.println(subString);
	}
}
