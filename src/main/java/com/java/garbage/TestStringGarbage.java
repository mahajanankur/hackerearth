/**
 * 
 */
package com.java.garbage;

/**
 * @author ankur.mahajan
 * @written 11-Jun-2019
 */
public class TestStringGarbage {

	static TestStringGarbage t;

	static int count = 0;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// firstTest();
		// secondTest();

		garbageCollectorCallsFinalizeOnceForObject();
	}

	private static void garbageCollectorCallsFinalizeOnceForObject() {
		TestStringGarbage t1 = new TestStringGarbage();
		t1 = null;
		System.gc();

		TestStringGarbage t2 = new TestStringGarbage();
		t2 = null;
		System.gc();
		TestStringGarbage t3 = new TestStringGarbage();
		t3 = null;
		System.gc();

		t1 = null;
		System.gc();
	}

	private static void secondTest() throws InterruptedException {
		TestStringGarbage t1 = new TestStringGarbage();

		// making t1 eligible for garbage collection
		t1 = null; // line 12

		// calling garbage collector
		System.gc(); // line 15

		// waiting for gc to complete
		Thread.sleep(1000);

		// making t eligible for garbage collection,
		t = null; // line 21

		// calling garbage collector
		System.gc(); // line 24

		// waiting for gc to complete
		Thread.sleep(1000);

		System.out.println("finalize method called " + count + " times");

	}

	private static void firstTest() {
		String a = new String("ankur");

		String b = "happu";

		TestStringGarbage garbage = new TestStringGarbage();

		garbage = null;

		a = null;

		System.gc();

		// Runtime.getRuntime().gc();

		System.out.println("end");

	}

	// FOR secondTest()
	// protected void finalize() throws Throwable {
	// count++;
	// t = this; // line 38
	// }

	protected void finalize() throws Throwable {
		System.out.println("finalize method called");
		// System.out.println(10 / 0);
	}

}
