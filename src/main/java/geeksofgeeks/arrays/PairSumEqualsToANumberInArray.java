package geeksofgeeks.arrays;

public class PairSumEqualsToANumberInArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 45, 6, 10, -8 };
		int x = -4;
		firstApproach(arr, x);

	}

	private static void firstApproach(int[] arr, int x) {
		String result = null;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == x) {
					result = "Pair having sum : " + x + " is {" + arr[i] + ", "
							+ arr[j] + "}";
				}
			}
		}
		if (result != null) {
			System.out.println(result);
		}
		else {
			System.out.println("No pair present in the array having sum " + x);
		}
	}
}
