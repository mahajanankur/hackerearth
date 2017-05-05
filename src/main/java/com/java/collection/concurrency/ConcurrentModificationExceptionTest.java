/**
 * 
 */
package com.java.collection.concurrency;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author amahajan
 *
 * @written 21-Apr-2017
 */
public class ConcurrentModificationExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ankur");
		list.add("mahajan");
		list.add("happy");
		for (Iterator<String> it = list.iterator(); it.hasNext();) {
			// String next = it.next();
			it.remove();
		}
		System.out.println(list);
		// firstApproach();

	}

}
