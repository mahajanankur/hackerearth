/**
 * 
 */
package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 29-Nov-2018
 */
public class PowerQuery {

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
		long query = Long.parseLong(br.readLine());
		long count = 0;
		while (query > count) {
			String readLine = br.readLine();
			String[] split = readLine.split(" ");
			long l = Long.parseLong(split[0]);
			long r = Long.parseLong(split[1]);

			// List<Long> list = new ArrayList<>();
			long sum = 0;
			long twos = 1;
			while (r > twos) {
				twos *= 2;

				if (twos >= l && twos <= r) {
					// String binaryString = Long.toBinaryString(twos);
					// list.add(twos);
					sum += twos;

				}

			}
			System.out.println(sum);
			count++;
		}

	}

}
