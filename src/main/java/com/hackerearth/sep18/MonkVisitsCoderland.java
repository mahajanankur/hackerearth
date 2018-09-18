/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 14-Sep-2018
 */
public class MonkVisitsCoderland {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws Exception {
		firstApproach();
	}

	private static void firstApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		int currentTest = 0;
		while (testCases > currentTest) {
			br.readLine();
			String[] costArray = br.readLine().split(" ");
			String[] litersArray = br.readLine().split(" ");
			long karcha = Long.parseLong(costArray[0].trim()) * Long.parseLong(litersArray[0].trim());
			long minimumPetrolPrice = Long.parseLong(costArray[0].trim());
			for (int i = 1; i < costArray.length; i++) {
				if (minimumPetrolPrice <= Long.parseLong(costArray[i].trim())) {
					karcha += minimumPetrolPrice * Long.parseLong(litersArray[i].trim());
				}
				else {
					karcha += Long.parseLong(costArray[i].trim()) * Long.parseLong(litersArray[i].trim());
					minimumPetrolPrice = Long.parseLong(costArray[i].trim());
				}
			}
			currentTest++;
			System.out.println("\n" + karcha);
		}

	}

}
