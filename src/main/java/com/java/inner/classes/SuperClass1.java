/**
 * 
 */
package com.java.inner.classes;

/**
 * @author ankur.mahajan
 * @written 25-Mar-2018
 */
public class SuperClass1 {

	static class NestedClass {
		public NestedClass() {
			System.out.println("Creating NestedClass object.");
		}

		public void method1() {
			System.out.println("In Nested Class method.");
		}
	}

	class InnerClass {
		public InnerClass() {
			System.out.println("Creating InnerClass object.");
		}

		public void method1() {
			System.out.println("In Nested Class method.");
		}
	}
}
