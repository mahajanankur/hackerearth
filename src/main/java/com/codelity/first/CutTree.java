/**
 * 
 */
package com.codelity.first;

/**
 * @author ankur.mahajan
 * @written 05-Dec-2018
 */
public class CutTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] n = { 4, 5, 1, 6 };
		int[] m = { 3, 5, 1, 2 };
		int[] o = { 3, 5, 1, 4 };
		int[] p = { 5, 2, 4, 6 };
		int[] q = { 5, 2, 6, 8 };
		int[] r = { 5, 2, 5, 8 };

		/*
		 * int [] m = {3,4,5,4}; int [] o = {1,2,3,4,7,5}; int [] p =
		 * {1,2,5,5,5,5};
		 */

		System.out.println(solution(n));
		System.out.println(solution(m));
		System.out.println(solution(o));
		System.out.println(solution(p));
		System.out.println(solution(q));
		System.out.println(solution(r));

	}

	static int solution(int n[]) {

		int returnVal = -1;
		int count = 0;
		int index = -1;

		for (int i = 0; i < n.length - 1; i++) {

			if (n[i + 1] < n[i]) {
				count++;
				index = i;
				if (count > 1) {
					returnVal = 0;
					break;
				}

			}
		}

		if (count == 1) {

			if (index == (n.length - 1) || index == (0)) {
				returnVal = 2;
			} else {

				if (index != 0 && ((n[index - 1] > n[index + 1]) || (n[index + 2] > n[index]))) {
					returnVal = 0;
					if ((n[index - 1] > n[index + 1])) {
						if ((n[index + 2] > n[index])) {
							returnVal = 1;
						}
					} else if ((n[index + 2] < n[index])) {
						if (!(n[index - 1] > n[index + 1])) {
							returnVal = 1;
						}
					}

				}
			}
		}

		if (count == 0) {
			returnVal = n.length;
		}

		return returnVal;
	}

}
