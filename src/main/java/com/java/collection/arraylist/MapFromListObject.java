/**
 * 
 */
package com.java.collection.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ankur.mahajan
 * @written 16-Oct-2018
 */
public class MapFromListObject {

	public static void main(String[] args) {
		List<DtoSalary> ls = new ArrayList<>();
		ls.add(new DtoSalary(1L, 10.00, 100L));
		ls.add(new DtoSalary(2L, 10.00, 200L));
		ls.add(new DtoSalary(3L, 10.00, 100L));
		ls.add(new DtoSalary(4L, 10.00, 300L));
		ls.add(new DtoSalary(5L, 10.00, 200L));
		ls.add(new DtoSalary(6L, 10.00, 100L));
		ls.add(new DtoSalary(7L, 10.00, 300L));
		ls.add(new DtoSalary(8L, 10.00, 100L));
		ls.add(new DtoSalary(9L, 10.00, 100L));

		// List<String> list = null;
		// List<String> list = new ArrayList<>();

		// for (String s : list) {
		// System.out.println(s);
		// }

		// formMapFromList(ls);
	}

	private static void formMapFromList(List<DtoSalary> ls) {
		Map<Long, List<DtoSalary>> salaryHistoryMap = new HashMap<>();
		for (DtoSalary salaryHistory : ls) {
			Long primaryAssignmentId = salaryHistory.getAssignmentId();
			List<DtoSalary> salaryHistoryList = null;
			if (null == salaryHistoryMap.get(primaryAssignmentId)) {
				salaryHistoryList = new ArrayList<>();

			} else {
				salaryHistoryList = salaryHistoryMap.get(primaryAssignmentId);
			}
			salaryHistoryList.add(salaryHistory);
			salaryHistoryMap.put(primaryAssignmentId, salaryHistoryList);
		}

		for (Map.Entry<Long, List<DtoSalary>> entry : salaryHistoryMap.entrySet()) {
			System.out.println(entry.getKey());
			List<DtoSalary> value = entry.getValue();
			for (DtoSalary dtoSalary : value) {
				System.out.println(dtoSalary.getSalaryAmount());
			}
		}

	}
}
