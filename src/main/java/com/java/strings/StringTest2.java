/**
 * 
 */
package com.java.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.itextpdf.text.log.SysoCounter;

/**
 * @author ankur.mahajan
 * @written 30-Nov-2018
 */
public class StringTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "Hourly";
		
		if (null == test || (null != test
				&& test.toLowerCase().contains("Annual".toLowerCase()))) {
			System.out.println("Yes");
		}else
			System.out.println("No");
		
		List<Double> ls = new ArrayList<>();
		ls.add(10.00);
		ls.add(1.00);
		ls.add(100.00);
		ls.add(103.00);
		ls.add(2.30);
		ls.add(0.50);
		ls.add(10.00);
		Collections.sort(ls);
		
		ls.forEach(x -> System.out.println(x));
		
	}

}
