/**
 * 
 */
package com.java.genrics.constructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ankur.mahajan
 * @written 28-Mar-2019
 */
public class GenericConstructorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Hello";
		GenericConstructor c1 = new GenericConstructor(s);
		GenericConstructor c2 = new <String> GenericConstructor("Ankur");
		// GenericConstructor c3 = new <String, Long> GenericConstructor(10);
		GenericConstructor c4 = new <Integer> GenericConstructor(10);

		GenericConstructor c5 = new <String, Long> GenericConstructor();

		List l1 = new <String, Integer> ArrayList();
		// TODO - List test.
		List l2 = new <String> ArrayList();
		l2.add("a");
		l2.add("b");
		l2.add("c");

		GenericConstructor c6 = new <Child1> GenericConstructor(new Child1("Ankur"));
		

	}

}
