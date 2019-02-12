package com.java.serialization;

/**
 * 
 */

/**
 * @author amahajan
 * 
 */
// public class Parent implements Serializable {
public class Parent {

	// private static final long serialVersionUID = 1L;

	int id;

	public Parent(int id) {
		System.out.println("Parent Class Constructor : " + id);
		this.id = id;
	}

	// REMEBER - De- Serialization: At the time of de-serialization, if any
	// non-serializable superclass is present, then JVM will execute instance
	// control flow in the superclass. To execute instance control flow in a
	// class, JVM will always invoke default(no-arg) constructor of that class.
	// So every non-serializable superclass must necessarily contain default
	// constructor, otherwise we will get runtime-exception.
	public Parent() {

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parent [id=" + id + "]";
	}

}
