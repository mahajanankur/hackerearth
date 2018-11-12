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
		// char c = 'a';
		// char d = 'A';
		// int s = c + d;
		// System.out.println(s);
		Map<Person, String> map = new HashMap<Person, String>();
		Person person1 = new Person(1, "ankur");
		Person person2 = new Person(1, "ankur");
		Person person3 = person2;
		// Person person2 = person1;

		System.out.println("Hashcode 1: " + person1.hashCode());
		System.out.println("Hashcode 2: " + person2.hashCode());
		System.out.println("Hashcode 3: " + person3.hashCode());

		map.put(person1, "First");
		map.put(person2, "Second");
		map.put(person3, "Third");

		for (Map.Entry<Person, String> string : map.entrySet()) {
			System.out.println(string);
		}
		// if (person1.hashCode() == person2.hashCode())
		System.out.println("Size of map : " + map.size());
		System.out.println(map.get(person1));
		System.out.println(map.get(person2));
		System.out.println(map.get(person3));

	}

}
