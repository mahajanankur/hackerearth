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
public class LittleJhool {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int count = 0;
		while (tc > count) {
			int students = Integer.parseInt(br.readLine());
			String input = br.readLine();
			String[] split = input.split(" ");
			int boys = Integer.parseInt(split[0]);
			int girls = Integer.parseInt(split[1]);
			if (Math.abs(boys - girls) > 1) {
				System.out.println("Little Jhool wins!");
			}
			else {
				System.out.println("The teacher wins!");
			}
			count++;
		}

	}

}
