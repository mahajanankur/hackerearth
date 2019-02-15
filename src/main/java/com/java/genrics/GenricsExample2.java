/**
 * 
 */
package com.java.genrics;

import com.java.collection.comparator.Person2;

/**
 * @author amahajan
 *
 */
public class GenricsExample2<E> {

	public <A extends Person2> A get(String str) {
		System.out.println("in Generic");
		Person2 person = new Person2("Ankur", "mahajan", "454545");
		A a = (A) person;
		return a;

	}

	public static <T extends Person2> T firstGenericTest(T a) {

		return (T) new Person2("Ankur", "mahajan", "454545");
	}

	public E firstGenericTest(String a) {

		return (E) new Person2("Ankur", "mahajan", "454545");
	}
}
