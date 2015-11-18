package com.hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dream On
 */
public class SubString {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String n = br.readLine();
			if (Integer.valueOf(n) > 0 && Integer.valueOf(n) <= 10) {
				int c = 0;
				String b = "^[A-Ca-c]+$";
				List<String> e = new ArrayList<String>();
				int r[] = new int[Integer.valueOf(n)];
				while (c < Integer.valueOf(n)) {
					int d = 0;
					String a = br.readLine();
					for (int i = 0; i < a.length(); i++) {
						for (int j = 1; j <= a.length() - i; j++) {
							e.add(a.substring(i, i + j));
						}
					}
					for (String s : e) {
						if (s != null && s.matches(b)) {

							d++;
						}
					}
					r[c] = d;
					e = new ArrayList<String>();
					c++;

				}
				for (int i = 0; i < r.length; i++) {
					System.out.println(r[i]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
