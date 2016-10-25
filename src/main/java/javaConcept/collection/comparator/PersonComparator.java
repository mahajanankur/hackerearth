/**
 * 
 */
package javaConcept.collection.comparator;

import java.util.Comparator;

/**
 * @author amahajan
 * 
 */
public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		int checkForFirstName = o1.getFirstName().compareTo(o2.getFirstName());
		if (checkForFirstName == 0) {
			int checkForLastName = o1.getLastName().compareTo(o2.getLastName());
			int ret = 0;
			if (checkForLastName == 0) {
				ret = 0;
			} else if (checkForLastName > 0) {
				ret = 1;
			} else if (checkForLastName < 0) {
				ret = -1;
			}
			return ret;
		} else if (checkForFirstName > 0) {
			return 1;
		} else if (checkForFirstName < 0) {
			return -1;
		}
		return checkForFirstName;
	}

}
