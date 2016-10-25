package javaConcepts.questions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubSetOfAList {

	public static void main(String[] args) {
		List<Character> ls = new ArrayList<Character>();
		ls.add('a');
		ls.add('b');
		ls.add('c');
		ls.add('d');
		ls.add('e');
		ls.add('f');
		ls.add('g');

		int subIndex[] = new int[] { 1, 4, 5 };
		Map<Integer, Character> result = new LinkedHashMap<Integer, Character>();

		for (int i = 0; i < subIndex.length; i++) {
			result.put(i, ls.get(subIndex[i] - 1));
		}
		System.out.println(result.values());

	}

}
