package com.java.questions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PaytmQuestion {

	public static void main(String[] args) {
		// firstApproach();
		// capital alphabets ascii value starts from 65 to 90 and small 97 to
		// 122.
		secondApproach();
	}

	private static void secondApproach() {
		String str = "ankur";
		str = str.toUpperCase();
		List<Integer> fiboList = new ArrayList<Integer>();
		int first = 0;
		int second = 1;
		int next = 0;

		fiboList.add(first);
		fiboList.add(second);
		while (fiboList.size() < 26) {
			next = first + second;
			first = second;
			second = next;
			fiboList.add(next);
		}
		System.out.println(fiboList);
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int index = (int) c - 65;
			sum += fiboList.get(index);

		}
		System.out.println(sum);
	}

	private static void firstApproach() {
		Map<Character, Integer> fiboMap = getFibbonaciMap();
		String str = "ankur";
		long sum = 0;
		char[] charArray = str.toCharArray();

		for (int i = 0; i < charArray.length; i++) {
			Integer val = fiboMap.get(charArray[i]);
			sum += val;
		}
		System.out.println(sum);
	}

	/**
	 * This method is used to get map of alphabets and its corresponding
	 * fibonacci number.
	 * 
	 * @return fiboMap
	 */
	private static Map<Character, Integer> getFibbonaciMap() {
		char[] alp = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z' };
		int firstFibo = 0;
		int secondFibo = 1;
		int next = 0;
		Map<Character, Integer> fiboMap = new LinkedHashMap<Character, Integer>();
		fiboMap.put(alp[0], firstFibo);
		fiboMap.put(alp[1], secondFibo);
		while (fiboMap.size() < 26) {
			int size = fiboMap.size();

			next = firstFibo + secondFibo;
			firstFibo = secondFibo;
			secondFibo = next;
			fiboMap.put(alp[size], next);
		}
		return fiboMap;
	}

}
