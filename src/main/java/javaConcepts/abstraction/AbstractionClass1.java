package javaConcepts.abstraction;

//public abstract class AbstractionClass1 {
public class AbstractionClass1 {

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method
	 * stub }
	 */
	private String a = "In AbstractionClass1";

	private int b;

	public String normalMethod(String a) {
		return "in normalMethod()";
	}

	// public abstract String abstractMethod1(String c);
	//
	// public abstract String abstractMethod2(int d);

	/**
	 * @return the a
	 */
	public String getA() {
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(String a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

}
