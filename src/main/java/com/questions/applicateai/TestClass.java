package com.questions.applicateai;

import java.util.Scanner;

class Solution {
	public void solution(int N) {
		int size = 2 * N - 1;
		int first = 0;
		int last = size - 1;
		int arr[][] = new int[size][size];
		while (N != 0) {
			for (int i = first; i <= last; i++) {
				for (int j = first; j <= last; j++) {
					if (i == first || i == last || j == first || j == last) {
						arr[i][j] = N;
					}
				}
			}
			first++;
			last--;
			N--;
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}

// Following is the part of the program and is provided as an assistance to read
// the input.

// 1 - 1
// 2 - 2 2 2
//	   2 1 2
//	   2 2 2

//3 -  3 3 3 3 3
//	   3 2 2 2 3
//	   3 2 1 2 3
//     3 2 2 2 3
//     3 3 3 3 3
public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Solution s = new Solution();
		s.solution(N);
	}
}
