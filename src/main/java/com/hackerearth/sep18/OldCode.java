/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 23-Sep-2018
 */
public class OldCode {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean loop = true;
		while (loop) {
			String line = reader.readLine();
			if (null == line || line.equals("")) {
				loop = false;
				break;
			}
			int indexOf = line.indexOf("//");
			String result = null;
			if (indexOf == -1) {
				result = line.replace("->", ".");
				System.out.println(result);
			}
			else {
				String leftHalf = line.substring(0, indexOf);
				// System.out.println(leftHalf);
				String right = line.substring(line.indexOf("//"), line.length());
				// System.out.println(right);
				String leftReplaced = leftHalf.replace("->", ".");
				result = leftReplaced + right;
				System.out.println(result);
			}

		}

	}

}
