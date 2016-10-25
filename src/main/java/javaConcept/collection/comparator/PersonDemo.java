/**
 * 
 */
package javaConcept.collection.comparator;

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
		pList.add(new Person("Saurabh", "Mahajan", "223595455"));
		pList.add(new Person("Ankur", "Mahajan", "223595"));
		pList.add(new Person("Saurabh", "Sharma", "22359454"));
		pList.add(new Person("Akriti", "Mahajan", "223595568"));
		pList.add(new Person("Sahil", "Sood", "223595952"));
		pList.add(new Person("Saurabh", "Mahajan", "25468"));
		pList.add(new Person("Saurabh", "Mahajan", "123"));
		pList.add(new Person("Sahil", "Gupta", "223595455"));
		pList.add(new Person("Ankit", "Sood", "223595455"));
		pList.add(new Person("Atul", "Mahajan", "223595455"));
		pList.add(new Person("Atul", "Sharma", "223595455"));

		// Compare first name then last name in a comparator.
		// compareInAClass(pList);
		compareInDifferentClasses(pList);

	}

	private static void compareInDifferentClasses(List<Person> pList) {
		Collections.sort(pList, new PersonMultiSequenceComparator(
				new PersonFirrstNameComparator(),
				new PersonLastNameComparator(), new PersonMobileComparator()));
		System.out.println(pList);
	}

	private static void compareInAClass(List<Person> pList) {
		Collections.sort(pList, new PersonComparator());
		System.out.println(pList);

	}

}
