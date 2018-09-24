/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 24-Sep-2018
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 * @throws
	 * 			@throws
	 *             NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		String emps = br.readLine();
		char[] charArray = emps.toCharArray();
		// V, N, G, T, S, B, P
		int v = 0;
		int n = 0;
		int g = 0;
		int t = 0;
		int s = 0;
		int b = 0;
		int p = 0;

		for (char c : charArray) {
			switch (c) {
			case 'V':
				v++;
				break;
			case 'N':
				n++;
				break;
			case 'G':
				g++;
				break;
			case 'T':
				t++;
				break;
			case 'S':
				s++;
				break;
			case 'B':
				b++;
				break;
			case 'P':
				p++;
				break;
			default:
				break;
			}
		}
		int worker = Integer.parseInt(br.readLine());
		int loop = 0;
		while (worker > loop) {
			String first = br.readLine();
			char[] charArray2 = first.toCharArray();
			int total = 1;
			for (char c : charArray2) {
				if (total == 0) {
					continue;
				}
				switch (c) {
				case 'V':
					total *= v;
					v--;
					break;
				case 'N':
					total *= n;
					n--;
					break;
				case 'G':
					total *= g;
					g--;
					break;
				case 'T':
					total *= t;
					t--;
					break;
				case 'S':
					total *= s;
					s--;
					break;
				case 'B':
					total *= b;
					b--;
					break;
				case 'P':
					total *= p;
					p--;
					break;
				default:
					break;
				}
			}
			System.out.println(total);
			loop++;
		}

	}

}
