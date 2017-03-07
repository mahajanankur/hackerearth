/**
 * 
 */
package com.java.collection.comparator;

import java.util.Comparator;

/**
 * @author amahajan
 * 
 */
public class PersonFirrstNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int compareTo = o1.getFirstName().compareTo(o2.getFirstName());
		return compareTo;
	}

}
