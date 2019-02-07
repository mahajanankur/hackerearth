package com.java.collection.sorting;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ankur.mahajan
 * @written 04-Feb-2019
 */
public class SortStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		firstApproach();
	}

	private static void firstApproach() {
		// DAY, WEEK, MONTH, QUATER, HALFYEAR, YEAR
		Set<String> set = new HashSet<>();
		set.add("YEAR");
		set.add("DAY");
		set.add("WEEK");
		set.add("QUATER");
		set.add("HALFYEAR");
		set.add("MONTH");
		set.stream().forEach(System.out::println);
		
		
	}

}
