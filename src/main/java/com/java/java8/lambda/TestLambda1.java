/**
 * 
 */
package com.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amahajan
 *
 * @written 25-Jan-2017
 */
public class TestLambda1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ankur");
		list.add("akriti");
		list.add("abhishek");
		list.add("sahil");
		list.add("happu");

		foreachInCollection(list);

	}

	private static void foreachInCollection(List<String> list) {
		list.forEach(System.out::println);

	}

}
