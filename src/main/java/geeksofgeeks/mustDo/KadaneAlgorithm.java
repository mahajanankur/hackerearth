/**
 * 
 */
package geeksofgeeks.mustDo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 18-Dec-2018
 */
public class KadaneAlgorithm {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// int[] a = { -1, -2, -11, 22, -11, 20 };
		int[] a = { -1, -2, -11, -11 };
		System.out.println(firstApproach(a));
		System.out.println(secondApproach(a));
		finalApproach();

	}

	private static void finalApproach() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		int loop = 0;
		while (tests > loop) {
			int size = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int maxSoFar = Integer.parseInt(arr[0]);
			int maxEndingHere = Integer.parseInt(arr[0]);
			for (int i = 1; i < size; i++) {
				maxEndingHere = Math.max(Integer.parseInt(arr[i]), maxEndingHere + Integer.parseInt(arr[i]));
				maxSoFar = Math.max(maxEndingHere, maxSoFar);
			}
			System.out.println(maxSoFar);
			loop++;
		}

	}

	private static int secondApproach(int[] a) {
		int maxSoFar = a[0], maxEndingHere = a[0];
		for (int i = 1; i < a.length; i++) {
			maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	/**
	 * This do not work for array having negative elements.
	 * 
	 * @param a
	 * @return
	 */
	private static int firstApproach(int[] a) {
		int maxSoFar = 0, maxEndingHere = 0;
		for (int i = 1; i < a.length; i++) {
			maxEndingHere += a[i];
			if (maxEndingHere < 0)
				maxEndingHere = 0;
			else if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}

}
