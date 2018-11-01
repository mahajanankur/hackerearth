/**
 * 
 */
package com.java.java8.stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.itextpdf.text.log.SysoCounter;

/**
 * @author ankur.mahajan
 * @written 27-Oct-2018
 */
public class Example1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		long count = stream.count();
		// stream.filter(p -> p.equals("Ankur"));
		stream.close();

		Stream<String> stream1 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		boolean allMatch = stream1.allMatch(x -> x.contains("a"));
		stream1.close();
		Stream<String> stream3 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		boolean anyMatch = stream3.anyMatch(x -> x.contains("za"));
		stream3.close();
		Stream<String> stream4 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		List<String> distinct = stream4.distinct().collect(Collectors.toList());
		stream4.close();
		Stream<String> stream5 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		List<String> collect = stream5.collect(Collectors.toList());
		stream5.close();
		Stream<String> stream6 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		List<String> filter = stream6.filter(x -> x.equals("ankur")).collect(Collectors.toList());
		;
		stream6.close();
		Stream<String> stream7 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		List<String> sorted = stream7.sorted().collect(Collectors.toList());
		stream7.close();
		Stream<String> stream8 = Stream.of("ankur", "happu", "atu", "sahil", "akriti");
		stream8.forEach(System.out::println);
		stream8.close();

		// Next
		IntSummaryStatistics summaryStatistics = IntStream.range(0, 10).summaryStatistics();
		// .forEach(x -> System.out.println(x));
		System.out.println(summaryStatistics);

		Stream<Integer> stream2 = Stream.of(1, 12, 7, 6, 0, 3);
		List<Integer> collect2 = stream2.filter(x -> x > 5).map(x -> x * x).collect(Collectors.toList());
		stream2.close();

		Stream<String> stream9 = Stream.of("jatin ", "works", " G4s");
		// String string = stream9.reduce((a, b) -> a + b).toString();
		// String string = stream9.reduce((a, b) -> transform(a, b)).toString();
		List<String> collect3 = stream9.map(x -> transform(x)).collect(Collectors.toList());
		// System.out.println(stream9.filter(a -> a.contains(" ")).map(x ->
		// x.concat("_")).toString());
		System.out.println();
	}

	private static String transform(String a) {

		if (a.contains(" ")) {
			a = a.concat("_");
		}

		return a;
	}

}
