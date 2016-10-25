/**
 * 
 */
package javaConcept.collection.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author amahajan
 * 
 */
public class PersonMultiSequenceComparator implements Comparator<Person> {

	private List<Comparator<Person>>	compList;

	public PersonMultiSequenceComparator(Comparator<Person>... comparator) {
		this.compList = Arrays.asList(comparator);
	}

	@Override
	public int compare(Person o1, Person o2) {

		for (Comparator<Person> com : compList) {
			int compare = com.compare(o1, o2);
			if (compare != 0) {
				return compare;
			}
		}
		return 0;
	}

}
