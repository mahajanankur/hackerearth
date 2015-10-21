package geeksforgeeks.miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PoweSubSetsOfAString {

	public static void main(String[] args) {
		String str = "abcd";
		int n = str.length();
		char[] charArray = str.toCharArray();
		List<String> ps = new ArrayList<String>();
		for (char c : charArray) {
			ps.add(c + "");
		}
		// firstApproach(str);
		// secondApproach(str);
		// thirdApproach(str);
		getpowerset(charArray, n, ps);

	}

	public static ArrayList<String> getpowerset(char a[], int n, List<String> ps) {
		if (n < 0) {
			return null;
		}
		if (n == 0) {
			if (ps == null)
				ps = new ArrayList<String>();
			ps.add(" ");
			return (ArrayList<String>) ps;
		}
		ps = getpowerset(a, n - 1, ps);
		ArrayList<String> tmp = new ArrayList<String>();
		for (String s : ps) {
			if (s.equals(" "))
				tmp.add("" + a[n - 1]);
			else
				tmp.add(s + a[n - 1]);
		}
		ps.addAll(tmp);
		return (ArrayList<String>) ps;
	}

	private static void thirdApproach(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j <= str.length(); j++) {
				String sub = str.substring(i, j);
				res.append("{").append(sub).append("},");
			}
		}
		System.out.println(res);

	}

	private static void secondApproach(String str) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i <= str.length(); i++) {

			for (int j = 0; j <= str.length(); j++) {

				if (j >= i) {
					String sub = str.substring(i, j);
					if ((i == 0 && j == 0) || (sub != null && !sub.equals(""))) {
						res.append("{").append(sub).append("},");

					}
				}
			}
		}
		System.out.println(res);

	}

	private static void firstApproach(String str) {
		int strLength = str.length();
		int powerSetSize = (int) Math.pow(2, strLength);

		for (int i = 0; i < powerSetSize; i++) {
			for (int j = 0; j < strLength; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.printf("%c", str.charAt(j));
				}
				// System.out.print("%n");
			}
		}

	}
}
