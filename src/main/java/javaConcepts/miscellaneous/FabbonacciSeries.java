package javaConcepts.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FabbonacciSeries {

	public static void main(String[] args) {
		// firstApproach();
		secondApproach();

	}

	private static void secondApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int testCase = Integer.parseInt(br.readLine());
			if (testCase > 0 && testCase < 100000) {
				int loop = 0;
				List<Long> list = new ArrayList<Long>();
				String result[] = new String[testCase];
				while (testCase > loop) {
					long testNumber = Long.parseLong(br.readLine());

					long next, prev, sum;
					next = prev = 1;
					for (long i = 1; i < testNumber * 3; i++) {
						list.add(prev);
						sum = next + prev;
						prev = next;
						next = sum;
					}
					boolean contains = list.contains(testNumber);
					if (contains) {
						result[loop] = "IsFibo";
					} else {
						result[loop] = "IsNotFibo";
					}

					loop++;
				}
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void firstApproach() {
		int next, prev, sum, testNumber;
		next = prev = 1;
		testNumber = 13;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 100; i++) {
			list.add(prev);
			sum = next + prev;
			prev = next;
			next = sum;
		}
		boolean contains = list.contains(testNumber);
		if (contains) {
			System.out.println("IsFibo");
		} else {
			System.out.println("IsNotFibo");
		}
	}

}
