/**
 * 
 */
package com.java.enums;

/**
 * @author amahajan
 *
 * @written 15-Mar-2017
 */
enum Enum2 {

	DOG, CAT, COW;
}

public class EnumTest1 {

	public static void main(String[] args) {
		EnumTest1 test1 = new EnumTest1();
		test1.getEnumVariables();
	}

	private void getEnumVariables() {
		Enum2 cat = Enum2.CAT;
		System.out.println(cat);

	}

}
