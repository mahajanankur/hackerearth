/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author ankur.mahajan
 * @written 24-Sep-2018
 */
public class MillyLovesChocolates {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int loop = 0;
		while (tc > loop) {
			long items = Long.parseLong(br.readLine());
			String str = br.readLine();
			String[] split = str.split(" ");
			long totalSum = 0;
			for (int i = 0; i < split.length; i++) {
				totalSum += Long.parseLong(split[i]);
			}

			DecimalFormat df = new DecimalFormat("#.########");
			df.setRoundingMode(RoundingMode.CEILING);
			String format = df.format(Double.parseDouble(totalSum + "") / Double.parseDouble(items + ""));
			String numb = Double.parseDouble(format) + "";
			String substring = numb.substring(numb.indexOf('.'));
			while (substring.length() < 9) {
				substring += "0";
				numb += "0";

			}
			System.out.println(numb);
			loop++;
		}
	}

}
