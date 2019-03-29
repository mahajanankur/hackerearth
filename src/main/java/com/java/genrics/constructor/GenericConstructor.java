/**
 * 
 */
package com.java.genrics.constructor;

/**
 * @author ankur.mahajan
 * @written 28-Mar-2019
 */
public class GenericConstructor {

	private Object o;

	public <T> GenericConstructor(T type) {
		System.out.println("In generic constructor.");
		System.out.println(type.hashCode());
		o = type;
	}

	public GenericConstructor() {
		System.out.println("In default constructor.");
	}

	public <X extends Number> GenericConstructor(X type) {
		System.out.println("In X extends Number generic constructor.");
		System.out.println(type.hashCode());
	}

	public <Y extends Parent> GenericConstructor(Y type) {
		System.out.println("In Y extends Parent generic constructor.");
		System.out.println(type.hashCode());
	}

	/**
	 * @return the o
	 */
	public Object getO() {
		return o;
	}

	/**
	 * @param o
	 *            the o to set
	 */
	public void setO(Object o) {
		this.o = o;
	}

}
