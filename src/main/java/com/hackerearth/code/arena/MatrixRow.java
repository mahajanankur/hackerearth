/**
 * 
 */
package com.hackerearth.code.arena;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 25-Sep-2018
 */
public class MatrixRow {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int outerLoop = 0;
		while (tc > outerLoop) {
			String first = br.readLine();
			String[] split = first.split(" ");
			int rows = Integer.parseInt(split[0]);
			int columns = Integer.parseInt(split[1]);
			int loop = 0;
			List<String> list = new ArrayList<>();
			while (rows > loop) {
				list.add(br.readLine());
				loop++;
			}
			Collections.sort(list);
			boolean same = false;
			for (String string : list) {
				if (list.indexOf(string) != list.lastIndexOf(string)) {
					same = true;
					break;
				}
			}
			if (same) {
				System.out.println("No");
			}
			else {
				System.out.println("Yes");
			}
			outerLoop++;
		}

	}

}
