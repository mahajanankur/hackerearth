package javaConcepts.abstraction;

public class TestAbstract2 {

	public static void main(String[] args) {

		AbstractionClass1 ab = new AbstractionClass1();
		AbstractionClass1 bc = new TestAbstract1();

		System.out.println(ab.getA());
		// compile time error
		// System.out.println(bc.c);
		System.out.println(bc.getB());
	}

}
