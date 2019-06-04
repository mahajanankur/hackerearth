/**
 * 
 */
package com.java.passbyvalue;

/**
 * @author amahajan
 *
 * @written 28-Jun-2017
 */
public class TestPassByValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// check pass by value and the value should not be changed.
		Dog dog = new Dog("sultaan");
		checkPassByValue(dog);
		System.out.println("Dog Name after MAIN() method return : " + dog.getName());

		// Value would change as only the value has been changed not reference.
		changeValueOfObject(dog);
		System.out.println("Dog Name after changeValueOfObject() method return : " + dog.getName());

	}

	private static void changeValueOfObject(Dog dog) {
		System.out.println("Dog Name in checkPassByValue() : " + dog.getName());
		dog.setName("boxer");

	}

	private static void checkPassByValue(Dog dog) {
		System.out.println("Dog Name in checkPassByValue() : " + dog.getName());
		dog = new Dog("boxer");
		System.out.println("Dog Name in checkPassByValue() after changing value : " + dog.getName());
	}

}
