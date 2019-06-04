/**
 * 
 */
package com.java.math;

/**
 * @author ankur.mahajan
 * @written 27-May-2019
 */
public class RoundingFloat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float a = 22.7859f;
		float b = 22.70f;
		// float a = 286.786f;
		// float b = 286.7868f;
		// float e = 286.700f;
		// float f = 286.7f;
		// if (e == f) {
		// System.out.println("Equal");
		// }

		// float round = (float) (Math.round(b * 1000.0) / 1000.0);
		// System.out.println(round);
		float d = b - a;
		// float del = Math.abs(b - a);
		float del = Math.abs(a - b);
		System.out.println(del);
		float thres = 0.01f;
		if (del < thres) {
			System.out.println("Equal till 2 places.");
		}

	}

}
