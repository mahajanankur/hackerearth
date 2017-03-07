/**
 * 
 */
package com.java.collection.comparator;

import java.util.Comparator;

/**
 * @author amahajan
 * 
 */
public class PersonMobileComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int compareTo = o1.getMobile().compareTo(o2.getMobile());
		return compareTo;
	}

}
