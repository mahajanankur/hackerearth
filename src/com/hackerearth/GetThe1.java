package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetThe1 {

	/**
	 * @param args
	 */
	private static String	number;

	public static void main(String[] args) {
		// firstApproach();
		finalApproach();
	}

	private static void finalApproach() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int tc = Integer.parseInt(br.readLine());

			if (tc > 0 && tc <= 1000) {
				String result[] = new String[tc];
				int loop = 0;
				while (tc > loop) {
					boolean resFlag = false;
					boolean flag = false;
					// Set<Integer> set = new LinkedHashSet<Integer>();
					List<Integer> list = new ArrayList<Integer>();
					while (true) {
						if (!flag) {
							number = br.readLine().trim();
							flag = true;
						}
						char[] array = number.toCharArray();
						int res = 0;

						for (int i = 0; i < array.length; i++) {
							res += Math.pow(Integer.parseInt("" + array[i]), 2);
						}
						// set.add(res);
						list.add(res);
						number = res + "";
						if (list.indexOf(res) != list.lastIndexOf(res)) {
							resFlag = false;
							break;
						}
						if (res == 1) {
							resFlag = true;
							break;
						}
					}
					int caseNo = loop + 1;
					if (resFlag) {
						// Case #1:YES
						result[loop] = "Case #" + caseNo + ":" + "YES";
					} else {
						result[loop] = "Case #" + caseNo + ":" + "NO";
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
		boolean resFlag = false;
		boolean flag = false;
		// Set<Integer> set = new LinkedHashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		while (true) {
			if (!flag) {
				number = "376";
				flag = true;
			}
			char[] array = number.toCharArray();
			int res = 0;

			for (int i = 0; i < array.length; i++) {
				res += Math.pow(Integer.parseInt("" + array[i]), 2);
			}
			// set.add(res);
			list.add(res);
			number = res + "";
			if (list.indexOf(res) != list.lastIndexOf(res)) {
				resFlag = false;
				break;
			}
			if (res == 1) {
				resFlag = true;
				break;
			}
		}
		if (resFlag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
