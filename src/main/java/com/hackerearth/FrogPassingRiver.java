package com.hackerearth;

import java.util.ArrayList;
import java.util.List;

public class FrogPassingRiver {

	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		int dCords = 5;
		int[] leavesCordsWithTime = new int[] { 1, 3, 1, 4, 2, 3, 5, 4 };
		List<Integer> resList = new ArrayList<>();
		for (int i = 0; i < leavesCordsWithTime.length; i++) {
			if (!resList.contains(leavesCordsWithTime[i])) {
				resList.add(leavesCordsWithTime[i]);
			}
			if (resList.size() == dCords) {
				System.out.println("Flog can pass the river in " + i + " seconds.");
				break;
			}
		}

	}

}
