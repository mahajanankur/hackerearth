/**
 * 
 */
package com.java.genrics;

import com.java.collection.comparator.Person;

/**
 * @author amahajan
 *
 */
public class GenricsExample2 {

	public <A extends Person> A get(String str) {
		System.out.println("in Generic");
		Person person = new Person("Ankur", "mahajan", "454545");
		A a = (A) person;
		return a;

	}
}
