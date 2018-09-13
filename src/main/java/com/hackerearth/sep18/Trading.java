/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 11-Sep-2018
 */
public class Trading {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		firstApproach();

	}

	private static void firstApproach() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstInput = br.readLine();
		String updateInput = br.readLine();
		String sellingInput = br.readLine();
		String[] baseInputArr = firstInput.split(" ");
		String[] updateInputArr = updateInput.split(" ");
		String[] sellingInputArr = sellingInput.split(" ");

		long numberOfWeapons = Long.parseLong(baseInputArr[0]);
		long currentAmount = Integer.parseInt(baseInputArr[2]);
		int currentLevel = 1;
		for (int i = 1; i <= numberOfWeapons; i++) {
			currentAmount = greedyApproach(updateInputArr, sellingInputArr, currentAmount, currentLevel);
		}
		System.out.println(currentAmount);

	}

	private static long greedyApproach(String[] updateInputArr, String[] sellingInputArr, long currentAmount, int currentLevel) {
		long updationCost = Long.parseLong(updateInputArr[currentLevel - 1]);
		long sellingCost = Long.parseLong(sellingInputArr[currentLevel - 1]);
		if (currentAmount < updationCost) {
			// Sell
			currentAmount += sellingCost;
		}
		else {
			long delta = currentAmount - updationCost;
			long nextSellingCost = Long.parseLong(sellingInputArr[currentLevel - 1]);
			// 1. if difference is greater than equals selling cost then
			// upgrade.
			// 2. or when delta is 0 check if next selling cost is greater than
			// current amount.
			if (delta >= sellingCost || (delta >= 0 && nextSellingCost > currentAmount)) {
				currentAmount -= updationCost;
				currentLevel++;
				return greedyApproach(updateInputArr, sellingInputArr, currentAmount, currentLevel);
			}
			else {
				// Sell
				currentAmount += sellingCost;
			}
		}
		return currentAmount;
	}
}
