/**
 * 
 */
package com.hackerearth.sep18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Stack;

/**
 * @author ankur.mahajan
 * @written 11-Sep-2018
 */
public class Trading {

	/**
	 * @param args
	 * @throws IOException
	 */
	/*
	 * public static void main(String[] args) throws IOException {
	 * firstApproach();
	 * }
	 */

	private static void firstApproach() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String firstInput = br.readLine();
		String updateInput = br.readLine();
		String sellingInput = br.readLine();
		String[] baseInputArr = firstInput.split(" ");
		String[] updateInputArr = updateInput.split(" ");
		String[] sellingInputArr = sellingInput.split(" ");

		long numberOfWeapons = Long.parseLong(baseInputArr[0]);
		long currentAmount = Integer.parseInt(baseInputArr[2]);
		int currentLevel = 1;
		for (int i = 1; i <= numberOfWeapons; i++) {
			currentAmount = greedyApproach(updateInputArr, sellingInputArr, currentAmount, currentLevel);
		}
		System.out.println(currentAmount);

	}

	private static long greedyApproach(String[] updateInputArr, String[] sellingInputArr, long currentAmount, int currentLevel) {
		long updationCost = Long.parseLong(updateInputArr[currentLevel - 1]);
		long sellingCost = Long.parseLong(sellingInputArr[currentLevel - 1]);
		if (currentAmount < updationCost) {
			// Sell
			currentAmount += sellingCost;
		}
		else {
			long delta = currentAmount - updationCost;
			long nextSellingCost = Long.parseLong(sellingInputArr[currentLevel - 1]);
			// 1. if difference is greater than equals selling cost then
			// upgrade.
			// 2. or when delta is 0 check if next selling cost is greater than
			// current amount.
			if (delta >= sellingCost || (delta >= 0 && nextSellingCost > currentAmount)) {
				currentAmount -= updationCost;
				currentLevel++;
				return greedyApproach(updateInputArr, sellingInputArr, currentAmount, currentLevel);
			}
			else {
				// Sell
				currentAmount += sellingCost;
			}
		}
		return currentAmount;
	}

	// SOLUTION

	static int mod = (int) (1e9 + 7);
	static InputReader in;
	static PrintWriter out;

	static int[] logTable;
	static int[][] rmq;

	static void sparseTable(long[] a) {
		int n = a.length;

		logTable = new int[n + 1];
		for (int i = 2; i <= n; i++)
			logTable[i] = logTable[i >> 1] + 1;

		rmq = new int[logTable[n] + 1][n];

		for (int i = 0; i < n; ++i)
			rmq[0][i] = i;

		for (int k = 1; (1 << k) < n; ++k) {
			for (int i = 0; i + (1 << k) <= n; i++) {
				int x = rmq[k - 1][i];
				int y = rmq[k - 1][i + (1 << k - 1)];
				rmq[k][i] = a[x] >= a[y] ? x : y;
			}
		}
	}

	static int get(int i, int j, long[] a) {
		int k = logTable[j - i];
		int x = rmq[k][i];
		int y = rmq[k][j - (1 << k) + 1];
		return a[x] >= a[y] ? x : y;
	}

	static void solve() {

		in = new InputReader(System.in);
		out = new PrintWriter(System.out);

		long n = in.nextLong();
		int m = in.nextInt();
		long b = in.nextLong();

		long[] p = new long[m + 1];
		long[] s = new long[m + 1];

		for (int i = 2; i <= m; i++) {
			p[i] = p[i - 1] + in.nextLong();
		}
		for (int i = 1; i <= m; i++)
			s[i] = in.nextLong();

		long[] dif = new long[m + 1];

		for (int i = 0; i <= m; i++) {
			dif[i] = s[i] - p[i];
		}

		int[] next = new int[m + 1];
		Stack<Integer> st = new Stack<>();

		for (int i = m - 1; i >= 0; i--) {
			while (!st.isEmpty() && dif[st.peek()] <= dif[i])
				st.pop();
			next[i] = st.isEmpty() ? m + 1 : st.peek();
			// debug(dif[i], i,next[i]);
			st.push(i);
		}
		sparseTable(dif);
		long ans = b;
		long j = 0;
		while (j < n) {
			int l = 0;
			int r = m;
			int idx = 0;
			while (r - l >= 0) {
				int mid = (r + l) >> 1;
				if (p[mid] <= ans) {
					idx = mid;
					l = mid + 1;
				}
				else
					r = mid - 1;
			}
			idx = get(0, idx, dif);
			if (dif[idx] == 0)
				break;
			if (next[idx] > m) {
				ans += (n - j) * dif[idx];
				break;
			}
			else {
				long z = (p[next[idx]] - ans + dif[idx] - 1) / dif[idx];
				z = Math.min(z, n - j);
				ans += z * dif[idx];
				j += z;
			}
		}

		out.println(ans);
		out.close();
	}

	static long add(long a, long b) {
		return (a + b) % mod;
	}

	static long mul(long a, long b) {
		return (a * b) % mod;
	}

	static long sub(long a, long b) {
		return (a - b + mod) % mod;
	}

	public static void main(String[] args) {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					solve();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "1", 1 << 26).start();
	}

	static class Pair implements Comparable<Pair> {

		long x, y;
		int i;

		Pair(long x, long y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Pair o) {
			return -Long.compare(this.x, o.x);
		}

		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair p = (Pair) o;
				return p.x == x && p.y == y;
			}
			return false;
		}

		@Override
		public String toString() {
			return x + " " + y + " " + i;
		}

		/*
		 * public int hashCode()
		 * {
		 * return new Long(x).hashCode() * 31 + new Long(y).hashCode();
		 * }
		 */

	}

	static String rev(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return sb.toString();
	}

	static long gcd(long x, long y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

	static long pow(long n, long p, long m) {
		long result = 1;
		if (p == 0) {
			return 1;
		}

		while (p != 0) {
			if (p % 2 == 1)
				result *= n;
			if (result >= m)
				result %= m;
			p >>= 1;
			n *= n;
			if (n >= m)
				n %= m;
		}

		return result;
	}

	static long pow(long n, long p) {
		long result = 1;
		if (p == 0)
			return 1;

		while (p != 0) {
			if (p % 2 == 1)
				result *= n;
			p >>= 1;
			n *= n;
		}
		return result;
	}

	static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}

	static class InputReader {

		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				}
				catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			}
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			}
			while (!isSpaceChar(c));
			return res * sgn;
		}

		public int[] nextIntArray(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}

		public long[] nextLongArray(int n) {
			long a[] = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}

		public String readString() {
			int c = snext();
			while (isSpaceChar(c)) {
				c = snext();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			}
			while (!isSpaceChar(c));
			return res.toString();
		}

		public String nextLine() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			}
			while (!isEndOfLine(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}

	}

}
