package javaConcepts.staticKeyword;

public class TestStatic2 {

	public static void main(String[] args) {

		TestStatic1 static1 = new TestStatic1();
		TestStatic1 static2 = new TestStatic1();
		TestStatic1 static3 = new TestStatic1();
		TestStatic1 static4 = new TestStatic1();

		static1.setName("Ankur Mahajan");
		static2.setName("Other");
		static1.setName("Shit..");
		
		System.out.println("In 2nd Block : " + static2.getName());
		System.out.println("In 3rd Block : " + static3.getName());
		System.out.println("In 4th Block : " + static4.getName());

	}

}
