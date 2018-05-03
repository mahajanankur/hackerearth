/**
 * 
 */
package com.java.collection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author amahajan
 * 
 */
public class PersonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Person> pList = new ArrayList<Person>();
		pList.add(new Person("Saurabh", "Mahajan", "223595455", 10));
		pList.add(new Person("Ankur", "Mahajan", "223595", 12));
		pList.add(new Person("Saurabh", "Sharma", "22359454", 3));
		pList.add(new Person("Akriti", "Mahajan", "223595568", 19));
		pList.add(new Person("Sahil", "Sood", "223595952", 54));
		pList.add(new Person("Saurabh", "Mahajan", "25468", 4));
		pList.add(new Person("Saurabh", "Mahajan", "123", 4));
		pList.add(new Person("Sahil", "Gupta", "223595455", 10));
		pList.add(new Person("Ankit", "Sood", "223595455", 0));
		pList.add(new Person("Atul", "Mahajan", "223595455", 87));
		pList.add(new Person("Atul", "Sharma", "223595455", 7));

		// Compare first name then last name in a comparator.
		// compareInAClass(pList);
		// compareInDifferentClasses(pList);
		simpleComparatorTest(pList);

	}

	private static void simpleComparatorTest(List<Person> pList) {
		for (Person person : pList) {
			System.out.println(person.getId() + "/n");
		}

	}

	private static void compareInDifferentClasses(List<Person> pList) {
		Collections.sort(pList, new PersonMultiSequenceComparator(new PersonFirrstNameComparator(),
				new PersonLastNameComparator(), new PersonMobileComparator()));
		System.out.println(pList);
	}

	private static void compareInAClass(List<Person> pList) {
		Collections.sort(pList, new PersonComparator());
		System.out.println(pList);

	}

}
