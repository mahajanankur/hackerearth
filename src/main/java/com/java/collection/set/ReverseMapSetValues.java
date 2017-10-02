/**
 * 
 */
package com.java.collection.set;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ankur.mahajan
 *
 */
public class ReverseMapSetValues {

	public static void main(String[] args) {
		Map<String, Set<String>> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		set.add("value1");
		set.add("value2");
		map.put("key1", set);

		set = new HashSet<>();
		set.add("value3");
		set.add("value2");
		map.put("key2", set);
		System.out.println("Input Map ## " + map);
		new ReverseMapSetValues().normalReverse(map);
	}

	public <T> Map<T, Set<T>> normalReverse(Map<T, Set<T>> map) {
		Map<T, Set<T>> result = new HashMap<>();
		Collection<Set<T>> valuesSet = map.values();
		for (Set<T> set : valuesSet) {
			for (T t : set) {
				Set<T> reversedValues = new HashSet<>();
				for (Map.Entry<T, Set<T>> entry : map.entrySet()) {
					if (entry.getValue().contains(t)) {
						reversedValues.add(entry.getKey());
					}
				}
				result.put(t, reversedValues);
			}
		}
		System.out.println("Output Map ## " + result);

		return result;

	}
}
