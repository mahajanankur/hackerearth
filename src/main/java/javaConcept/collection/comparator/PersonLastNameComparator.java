/**
 * 
 */
package javaConcept.collection.comparator;

import java.util.Comparator;

/**
 * @author amahajan
 * 
 */
public class PersonLastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int compareTo = o1.getLastName().compareTo(o2.getLastName());
		return compareTo;
	}
}
