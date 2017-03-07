package com.java.strings;

public class StringVsBufferInPool {

	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		String a = "ankur";

		String ab = new String(a);

		String abc = new String("ankur");

		StringBuffer buffer = new StringBuffer(a);

		StringBuilder builder = new StringBuilder(a);
		
		System.out.println(a==abc);
		System.out.println(a==ab);

		System.out.println("literal hashcode : " + a.hashCode());
		System.out.println("String object hashcode : " + ab.hashCode());
		System.out.println("Buffer hashcode : " + buffer.hashCode());
		System.out.println("Builder hashcode : " + builder.hashCode());
		System.out.println("String object hashcode : " + abc.hashCode());
	}

}
