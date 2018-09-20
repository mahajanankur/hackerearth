/**
 * 
 */
package geeksofgeeks.company.questions;

import java.util.Scanner;

/**
 * @author ankur.mahajan
 * @written 20-Sep-2018
 */
public class ClosestPalindromeAccepted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++) {
			int number = sc.nextInt();
			findClosestPalindrome(number);
		}
		sc.close();
	}

	private static void findClosestPalindrome(int number) {
		int numberRange = getRange(number);
		int palindrome = getPalindrome(number, numberRange);
		int leftPalindrome = 0, rightPalindrome = 0;
		int diff = (palindrome - number);
		if (diff == 0) {
			System.out.println(palindrome);
			return;
		}
		else if (diff < 0) {
			leftPalindrome = palindrome;
			int half = (int) Math.ceil(numberRange / 2d);
			int newNumber = (int) (number + (Math.pow(10, half)));

			rightPalindrome = getPalindrome(newNumber, findRange(newNumber, numberRange, true));
		}
		else {
			rightPalindrome = palindrome;
			int half = (int) Math.ceil(numberRange / 2d);
			int newNumber = (int) (number - (Math.pow(10, half)));
			leftPalindrome = getPalindrome(newNumber, findRange(newNumber, numberRange, false));
		}
		if ((number - leftPalindrome) > (rightPalindrome - number)) {
			System.out.println(rightPalindrome);
		}
		else {
			System.out.println(leftPalindrome);
		}
		return;
	}

	private static int findRange(int number, int oldRange, boolean increased) {
		if (increased) {
			if ((number / Math.pow(10, oldRange + 1) > 1)) {
				return oldRange + 1;
			}
		}
		else {
			if ((number / Math.pow(10, oldRange) < 1)) {
				return oldRange - 1;
			}
		}
		return oldRange;
	}

	private static int getPalindrome(int number, int numberRange) {
		int half = (int) Math.ceil(numberRange / 2d);
		int partNumber = (int) (Math.floor(number / Math.pow(10, half)));
		int palin = partNumber;
		if (numberRange % 2 == 0) {
			partNumber = partNumber / 10;
		}
		for (int i = 0; i < half; i++) {
			palin = (int) ((palin * 10) + partNumber % 10);
			partNumber = (int) (partNumber / 10);
		}
		return palin;
	}

	private static int getRange(int number) {
		int i = 0;
		while (number / 10 > 0) {
			number = number / 10;
			i++;
		}
		return i;
	}

}
