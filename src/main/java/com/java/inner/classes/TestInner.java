/**
 * 
 */
package com.java.inner.classes;

import com.java.inner.classes.SuperClass1.InnerClass;

/**
 * @author ankur.mahajan
 * @written 25-Mar-2018
 */
public class TestInner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SuperClass1 class1 = new SuperClass1();

		SuperClass1.NestedClass nestedClass = new SuperClass1.NestedClass();
		nestedClass.method1();

		InnerClass class2 = class1.new InnerClass();
		class2.method1();
	}

}
