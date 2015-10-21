package geeksofgeeks.arrays;

public class MajorityElement {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		int minOccure = arr.length / 2;
		firstApproach(arr, minOccure);
	}

	private static void firstApproach(int[] arr, int minOccure) {
		String result = null;
		for (int i = 0; i < arr.length; i++) {
			int counter = 0;
			for (int j = 0; j < arr.length; j++) {

				if (arr[i] == arr[j]) {
					counter++;
					if (counter >= minOccure) {
						result = "MajorityElement : " + arr[i];
						break;
					}
				}
			}
		}
		if (result != null) {
			System.out.println(result);
		}
		else {
			System.out.println("NONE");
		}
	}

}
