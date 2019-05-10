/**
 * 
 */
package com.java.collection.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author ankur.mahajan
 * @written 03-May-2019
 */
public class BatchOfAList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// batchOfList();
		batchOfSet();

	}

	private static void batchOfSet() {
		Set<Integer> lis = new HashSet<>();
		lis.add(10);
		lis.add(11);
		lis.add(12);
		lis.add(13);
		lis.add(14);
		lis.add(15);
		lis.add(16);
		lis.add(17);
		lis.add(18);
		lis.add(19);
		lis.add(20);
		lis.add(21);
		lis.add(22);
		int remaining = lis.size();
		int divider = 3;
		Iterator<Integer> iterator = lis.iterator();
		while (remaining > 0) {
			System.out.println("Batch number divider : " + divider);
			int batch = remaining / divider--;
			for (int i = 0; i < batch; i++) {
				// System.out.println(lis.get(i));
				System.out.println(iterator.next());
			}
			remaining -= batch;
		}

	}

	private static void batchOfList() {
		List<Integer> lis = new ArrayList<>();
		lis.add(10);
		lis.add(11);
		lis.add(12);
		lis.add(13);
		lis.add(14);
		lis.add(15);
		lis.add(16);
		lis.add(17);
		lis.add(18);
		lis.add(19);
		int remaining = lis.size();
		int divider = 3;
		int start = 0;
		while (remaining > 0) {
			System.out.println("Batch number divider : " + divider);
			int batch = remaining / divider--;
			int endIndex = start + batch;

			for (int i = start; i < endIndex; i++) {
				System.out.println(lis.get(i));
			}

			start = endIndex;
			remaining -= batch;
		}

	}

}
