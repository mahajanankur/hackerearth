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
public class MissingNumberInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		int loop = 0;
		while (tests > loop) {
			int size = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			long maxSum = (size * (1 + size)) / 2;
			long actualSum = 0;
			for (int i = 0; i < arr.length; i++) {
				actualSum += Integer.parseInt(arr[i]);
			}
			long missing = maxSum - actualSum;
			System.out.println(missing);
			loop++;
		}

	}

}
