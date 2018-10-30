/**
 * 
 */
package com.java.java8.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ankur.mahajan
 * @written 30-Oct-2018
 */
public class Example2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Entity1> list = new ArrayList<>();
		list.add(new Entity1(1L, "Ankur", "1234", new Date()));
		list.add(new Entity1(2L, "as", "44", new Date()));
		list.add(new Entity1(3L, "kj", "87", new Date()));
		list.add(new Entity1(4L, "hjs", "98", new Date()));
		list.add(new Entity1(5L, "happu", "233", new Date()));

		List<DtoEntity1> res = transformToDto(list);

		// List<DtoEntity1> collect = list.stream().map(x ->
		// transformToSingleDto(x)).collect(Collectors.toList());
		list.stream().map(x -> transformToSingleDto(x)).collect(Collectors.toList())
				.forEach(x -> System.out.println(x.getId()));
		;

		System.out.println("Done");

	}

	private static List<DtoEntity1> transformToDto(List<Entity1> list) {
		List<DtoEntity1> collect = list.stream()
				.map(x -> new DtoEntity1(x.getId(), x.getName(), x.getMobile(), x.getDob()))
				.collect(Collectors.toList());
		return collect;
	}

	private static DtoEntity1 transformToSingleDto(Entity1 x) {

		DtoEntity1 dtoEntity1 = new DtoEntity1(x.getId(), x.getName(), x.getMobile(), x.getDob());
		return dtoEntity1;
	}

}
