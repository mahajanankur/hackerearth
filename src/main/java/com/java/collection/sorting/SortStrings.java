package com.java.collection.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
		//firstApproach();
		secondApproach();
	}

	private static void secondApproach() {
		//r.rule_id as ruleId, r.priority as priority, r.type as type
		List<String> asList = Arrays.asList("ruleId", "priority", "type");
//		List<String> asList = Arrays.asList("ruleId", "subRuleId", "actionId", "type", "countryId", "actionType");
		Collections.sort(asList);
		for (String string : asList) {
			System.out.println(string);
		}

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
