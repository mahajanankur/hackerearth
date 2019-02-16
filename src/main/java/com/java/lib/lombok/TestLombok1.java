/**
 * 
 */
package com.java.lib.lombok;

/**
 * @author ankur.mahajan
 * @written 16-Feb-2019
 */
public class TestLombok1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DtoPojo1 dto = new DtoPojo1();
		dto.setId(10L);
		dto.setName("Ankur");
		System.out.println(dto.getAddress());
		System.out.println(dto.getId());
		

	}

}
