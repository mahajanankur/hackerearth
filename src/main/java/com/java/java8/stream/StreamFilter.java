/**
 * 
 */
package com.java.java8.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ankur.mahajan
 * @written 04-Jun-2019
 */
public class StreamFilter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstApproach();
		secondApproach();

	}

	private static void secondApproach() {
		List<Object[]> arr = new ArrayList<Object[]>();
		Object[] one = {10L, "Ankur", "12", new Date()};
		Object[] two = {10L, "Ankur", "12", new Date()};
		Object[] three = {10L, "Ankur", "12", new Date()};
		arr.add(one);
		arr.add(two);
		arr.add(three);
		
		// List<DtoEntity1> check = arr;

	}

	private static void firstApproach() {
		List<DtoEntity1> list1 = new ArrayList<DtoEntity1>();
		list1.add(new DtoEntity1(10L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(12L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(13L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(14L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(15L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(10L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(16L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(11L, "Ankur", "12", new Date()));
		list1.add(new DtoEntity1(12L, "Ankur", "12", new Date()));

		List<DtoEntity1> list2 = null;
		Long id = 10L;
		list2 = list1.stream().filter(x -> id.equals(x.getId())).collect(Collectors.toList());
		System.out.println(list2);

	}

}
