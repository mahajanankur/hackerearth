/**
 * 
 */
package com.hackerearth.newProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 04-Jun-2019
 */
public class FrustratedCoders {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		secondApproach();
	}
	public static void sortString() {
		List<String> stack = new ArrayList<>();
		stack.add("2");
		stack.add("8");
		stack.add("7");
		stack.add("4");
		stack.add("1");
		stack.add("7");
		stack.add("4");
		stack.add("2");
		Collections.sort(stack);
		stack.stream().forEach(System.out::println);
	}

	public static void firstApproach() {
		List<Integer> stack = new ArrayList<Integer>();
		stack.add(2);
		stack.add(8);
		stack.add(7);
		stack.add(4);
		stack.add(1);
		stack.add(7);
		stack.add(4);
		stack.add(2);

		Collections.sort(stack);
		int prev = 0;
		int current = 0;
		for (int i = 0; i < stack.size(); i++) {
			int ele = stack.get(prev);
			if (ele < stack.get(i)) {
				prev++;
				current++;

			}
		}
		int sum = 0;
		for (int i = current; i < stack.size(); i++) {
			sum += stack.get(i);
		}

		System.out.println(sum);
	}

	public static void secondApproach() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int elements = Integer.parseInt(br.readLine().trim());
		String readLine = br.readLine().trim();
		String[] stack = readLine.split(" ");
		Arrays.sort(stack);

		int prev = 0;
		int current = 0;
		for (int i = 0; i < elements; i++) {
			int ele = Integer.parseInt(stack[prev]);
			if (ele < Integer.parseInt(stack[i])) {
				prev++;
				current++;

			}
		}
		int sum = 0;
		for (int i = current; i < elements; i++) {
			sum += Integer.parseInt(stack[i]);
		}

		System.out.println(sum);
	}

}
