/**
 * 
 */
package com.java.collection.comparator;

import java.util.Comparator;

/**
 * @author amahajan
 * 
 */
public class SimplePersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// return o1.getFirstName().compareTo(o2.getFirstName());
		return o1.getId().compareTo(o2.getId());
	}

}
