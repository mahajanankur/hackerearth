/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 21-Sep-2018
 */
public class LittleArjitAndHisArmy {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int count = 0;
		while (tc > count) {
			String input = br.readLine();
			int start = 0;
			int end = 0;
			boolean loop = true;
			int remainingEnemy = 0;
			while (loop) {
				end = input.indexOf("*");
				if (end == -1) {
					end = input.length();
					loop = false;
				}
				int xNum = 0;
				int oNum = 0;
				String substring = input.substring(start, end);
				int subLeng = substring.length();
				for (int i = 0; i < subLeng; i++) {
					if (substring.charAt(i) == 'X') {
						xNum++;
					}
					else {
						oNum++;
					}
				}
				if (xNum < oNum) {
					if (xNum > 0) {
						remainingEnemy += oNum % xNum;
					}
					else {
						remainingEnemy += oNum;
					}
				}
				if (loop) {
					input = input.substring(end + 1, input.length());
				}
			}
			System.out.println(remainingEnemy);
			count++;
		}
	}

}
