/**
 * 
 */
package com.hackerearth.code.arena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 11-Dec-2018
 */
public class HockeyArena {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		firstApproach();

	}

	private static void firstApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		int loop = 0;
		long[] result = new long[testCases];
		while (testCases > loop) {
			String[] split = br.readLine().split(" ");
			long m = Long.parseLong(split[0]);
			long n = Long.parseLong(split[1]);
			if (m >= n) {
				result[loop] = n;
			} else {
				result[loop] = m;
			}
			loop++;
		}
		for (long l : result) {
			System.out.println(l);
		}

	}

}
