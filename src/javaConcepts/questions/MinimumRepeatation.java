package javaConcepts.questions;

import java.util.HashMap;
import java.util.Map;

public class MinimumRepeatation {

	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 5, 7, 3, 6, 5, 5, 8, 9, 2, 4, 6, 5, 3,
				8, 3, 9 };
		firstApproach(array);

	}

	private static void firstApproach(int[] array) {
		int valueCount = 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				valueCount++;
				map.put(array[i], valueCount);
			} else {
				valueCount = 1;
				map.put(array[i], valueCount);
			}
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				System.out.println("Key : " + entry.getKey() + " Value : "
						+ entry.getValue());
			}
		}

	}

}
