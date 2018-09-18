/**
 * 
 */
package com.hackerearth.sep18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 17-Sep-2018
 */
public class NewLanguage {

	/**
	 * @param args
	 */
	public enum Operations {
		SUM, SUBSTRACT, MULTIPLY, DIVISION;
	}

	public static void main(String[] args) {
		createMultiDArray(1, 10);
		int testCases = 9;
		long first = 79;
		long second = 1;
		char operation = '-';
		long result = 0;
		switch (operation) {
		case '-':
			result = substract(first, second);
			break;

		case '+':
			result = add(first, second);
			break;

		case '/':
			result = divide(first, second);
			break;

		case '*':
			result = multiply(first, second);
			break;
		}
		System.out.println(result);
	}

	private static long multiply(long first, long second) {
		long normalResult = first * second;
		String val = normalResult + "";
		if (val.contains("8")) {
			long[][] counting = createMultiDArray(1, normalResult);
			long newIndex = counting.indexOf(first) - counting.indexOf(second) - 1;
			return counting.get((int) (newIndex));
		}
		else {
			return normalResult;
		}
	}

	private static long divide(long first, long second) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static long add(long first, long second) {
		long normalResult = first + second;
		String val = normalResult + "";
		if (val.contains("8")) {
			List<Long> counting = new ArrayList<>();
			counting = createCountingForAddAndSubs(1, first + second, counting);
			long newIndex = counting.indexOf(first) + counting.indexOf(second) + 1;
			return counting.get((int) (newIndex));
		}
		else {
			return normalResult;
		}

	}

	private static long substract(long first, long second) {
		long normalResult = first - second;
		String val = normalResult + "";
		if (val.contains("8")) {
			List<Long> counting = new ArrayList<>();
			counting = createCountingForAddAndSubs(1, first + second, counting);
			long newIndex = counting.indexOf(first) - counting.indexOf(second) - 1;
			return counting.get((int) (newIndex));
		}
		else {
			return normalResult;
		}

	}

	private static List<Long> createCountingForAddAndSubs(long i, long actualValue, List<Long> result) {
		for (long j = i; j <= actualValue * 2; j++) {
			String value = j + "";
			if (!value.contains("8")) {
				result.add(j);
			}
		}
		return result;
	}

	private static long[][] createMultiDArray(long start, long actualValue) {
		int numberOfRows = (int) ((actualValue / 8) * 2);
		long[][] result = new long[numberOfRows][8];
		for (int i = 1; i <= numberOfRows; i++) {

			for (int j = 1; j <= result[i].length; j++) {
				String value = i + "";
				if (!value.contains("8")) {
					result[i][j] = i;
					System.out.println("Arr" + i + " " + j + "   Value : " + i);
				}
			}

		}
		return result;
	}
}
