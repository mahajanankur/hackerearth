/**
 * 
 */
package com.java.java8.inheritance.multiple;

/**
 * @author ankur.mahajan
 * @written 11-Jul-2019
 */
public class TestMultipleInharitence extends AbstractClass1 implements Interface1, Interface2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface1 interface1 = new TestMultipleInharitence();
		AbstractClass1 class1 = new TestMultipleInharitence();
		interface1.print();
		class1.print();
	}

	@Override
	public void print() {
		System.out.println("Hello There!!");

	}

}
