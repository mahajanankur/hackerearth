/**
 * 
 */
package com.java.collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amahajan
 *
 * @written Jun 2, 2016
 */
public class TestMap1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Person, String> map = new HashMap<Person, String>();
		Person person1 = new Person(1, "ankur");
		// Person person2 = new Person(1, "ankur");
		Person person2 = person1;

		map.put(person1, "First");
		map.put(person2, "Second");

		// for (Map.Entry<Person, String> string : map.entrySet()) {
		// System.out.println(string);
		// }
		// if (person1.hashCode() == person2.hashCode())
		System.out.println(map.get(person1));
		System.out.println(map.get(person2));

	}

}
