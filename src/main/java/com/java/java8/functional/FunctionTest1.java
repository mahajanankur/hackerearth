/**
 * 
 */
package com.java.java8.functional;

import java.util.function.Consumer;

/**
 * @author ankur.mahajan
 * @written 05-Jul-2019
 */
// @FunctionalInterface
interface Functional {

	int add(int a, int b);

	// int sub(int a, int b, int c);

}

public class FunctionTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// firstTest();
		// double percentage = percentage(10, 100);
		// System.out.println("Normal method " + percentage);
		// Consumer<Double> funPer = (double a, double b) -> a + b;
		Functional x = (m, n) -> m + n;
		System.out.println(x.add(10, 20));
		// funPer.accept(t);
		// double x = 10;
		// double y = 10;
		// percentage(() -> {
		// return x + y;
		// }, 100);

	}

	private static String firstTest() {
		Consumer<String> a = (b) -> {
			String c = "ankur mahajan";
			String d = b;
			System.out.println(d);
		};
		a.accept("Hello");
		return null;

	}

	private static double percentage(double a, double b) {
		double d = a / b;
		return d * 100;
	}

}
