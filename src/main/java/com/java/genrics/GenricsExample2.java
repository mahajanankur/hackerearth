/**
 * 
 */
package com.java.genrics;

import com.java.collection.comparator.Person2;

/**
 * @author amahajan
 *
 */
public class GenricsExample2 {

	public <A extends Person2> A get(String str) {
		System.out.println("in Generic");
		Person2 person = new Person2("Ankur", "mahajan", "454545");
		A a = (A) person;
		return a;

	}
}
