package javaConcepts.strings;

public class StringConcept {

	public static void main(String[] args) {

		// immuatableProperties();
		stackOverflowQuestion();
	}

	// b***b
	// *l*l*
	// **u**
	// *e*e*
	// j***j
	private static void stackOverflowQuestion() {
		String s = "bluej";
		int n = s.length() - 1;
		int i, j;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n; j++) {
				if (i == j || i == n - j)
					System.out.print(s.charAt(i));
				else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}

	private static void immuatableProperties() {
		String s1 = "abcdef";
		s1.concat("ankur");
		System.out.println(s1);
		String s2 = s1.substring(2, 4);
		s1 = s1 + s2;
		System.out.println(s1);
	}

}
