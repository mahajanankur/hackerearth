/**
 * 
 */
package geeksofgeeks.company.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 19-Sep-2018
 */
public class ClosestPalindrome {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// firstApproach();
		secondApproach();
	}

	private static void secondApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		long[] result = new long[tests];
		int loop = 0;
		while (tests > loop) {
			long number = Long.parseLong(br.readLine());
			boolean found = false;
			long incrementNumber = number;
			long decrementedNumber = number;

			while (!found) {
				boolean incrementedPalind = checkPalindrom(incrementNumber);
				boolean decrementedPalind = checkPalindrom(decrementedNumber);

				if (decrementedPalind) {
					result[loop] = decrementedNumber;
					found = true;
					break;
				}
				else if (incrementedPalind) {
					result[loop] = incrementNumber;
					found = true;
					break;
				}

				incrementNumber++;
				decrementedNumber--;

			}
			loop++;
		}

		for (long l : result) {
			System.out.println(l);
		}

	}

	private static void firstApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		long[] result = new long[tests];
		int loop = 0;
		while (tests > loop) {
			long number = Long.parseLong(br.readLine());

			for (long i = number;; i++) {
				boolean flag = checkPalindrom(i);
				if (flag) {
					result[loop] = i;
					break;
				}
			}
			loop++;
		}

		for (long l : result) {
			System.out.println(l);
		}

	}

	private static boolean checkPalindrom(long number) {
		boolean isPalindrom = true;
		String str = number + "";
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (!(charArray[i] == charArray[charArray.length - 1 - i])) {
				isPalindrom = false;
				break;
			}
		}
		return isPalindrom;
	}

}
