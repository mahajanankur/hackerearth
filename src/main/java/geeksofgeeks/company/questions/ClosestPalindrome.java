/**
 * 
 */
package geeksofgeeks.company.questions;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ankur.mahajan
 * @written 19-Sep-2018
 */
public class ClosestPalindrome {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// firstApproach();
		// secondApproach();
		// thirdApproach();
		optimizedApproach();
	}

	private static void optimizedApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		// long[] result = new long[tests];
		int loop = 0;
		while (tests > loop) {
			long number = Long.parseLong(br.readLine());
			String strValue = String.valueOf(number);
			int length = strValue.length();
			int middle = length / 2;
			String leftHalf = null;
			StringBuilder firstPalindrome = new StringBuilder();
			StringBuilder delta = new StringBuilder();
			if (length % 2 == 0) {
				leftHalf = strValue.substring(0, middle);
				firstPalindrome.append(leftHalf);
				delta.append("11");
				for (int i = 0; i < leftHalf.length(); i++) {
					firstPalindrome.append(leftHalf.charAt(leftHalf.length() - 1 - i));
					if (i > 0)
						delta.append("0");

				}

			}
			else {
				leftHalf = strValue.substring(0, middle + 1);
				firstPalindrome.append(leftHalf);
				delta.append("1");
				for (int i = 0; i < leftHalf.length() - 1; i++) {
					firstPalindrome.append(leftHalf.charAt(leftHalf.length() - 2 - i));
					delta.append("0");
				}
			}
			long firstPalin = Long.parseLong(firstPalindrome.toString());
			long actualDelta = Long.parseLong(delta.toString());
			long secondBigPalin = firstPalin + actualDelta;
			long thirdSmallPalin = firstPalin - actualDelta;
			if (Math.abs(number - firstPalin) > Math.abs(secondBigPalin - number)) {
				if (Math.abs(secondBigPalin - number) > Math.abs(number - thirdSmallPalin)) {
					System.out.println(thirdSmallPalin);
				}
				else if (Math.abs(secondBigPalin - number) == Math.abs(number - thirdSmallPalin)) {
					System.out.println(secondBigPalin > thirdSmallPalin ? thirdSmallPalin : secondBigPalin);
				}
				else {
					System.out.println(secondBigPalin);
				}
			}
			else {
				if (Math.abs(number - firstPalin) > Math.abs(number - thirdSmallPalin)) {
					System.out.println(thirdSmallPalin);
				}
				else if (Math.abs(number - firstPalin) == Math.abs(number - thirdSmallPalin)) {
					System.out.println(firstPalin > thirdSmallPalin ? thirdSmallPalin : firstPalin);
				}
				else {
					System.out.println(firstPalin);
				}

			}
			loop++;
		}
	}

	private static void thirdApproach() throws IOException {
		Reader reader = new Reader();
		int tests = reader.nextInt();
		long[] result = new long[tests];
		int loop = 0;
		while (tests > loop) {
			long number = reader.nextLong();
			boolean found = false;
			long incrementNumber = number;
			long decrementedNumber = number;

			while (!found) {
				boolean incrementedPalind = checkPalindrom(incrementNumber);
				boolean decrementedPalind = checkPalindrom(decrementedNumber);

				if (decrementedPalind) {
					result[loop] = decrementedNumber;
					found = true;
					break;
				}
				else if (incrementedPalind) {
					result[loop] = incrementNumber;
					found = true;
					break;
				}

				incrementNumber++;
				decrementedNumber--;

			}
			loop++;
		}

		for (long l : result) {
			System.out.println(l);
		}

	}

	private static void secondApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		long[] result = new long[tests];
		int loop = 0;
		while (tests > loop) {
			long number = Long.parseLong(br.readLine());
			boolean found = false;
			long incrementNumber = number;
			long decrementedNumber = number;

			while (!found) {
				boolean incrementedPalind = checkPalindrom(incrementNumber);
				boolean decrementedPalind = checkPalindrom(decrementedNumber);

				if (decrementedPalind) {
					result[loop] = decrementedNumber;
					found = true;
					break;
				}
				else if (incrementedPalind) {
					result[loop] = incrementNumber;
					found = true;
					break;
				}

				incrementNumber++;
				decrementedNumber--;

			}
			loop++;
		}

		for (long l : result) {
			System.out.println(l);
		}

	}

	private static void firstApproach() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		long[] result = new long[tests];
		int loop = 0;
		while (tests > loop) {
			long number = Long.parseLong(br.readLine());

			for (long i = number;; i++) {
				boolean flag = checkPalindrom(i);
				if (flag) {
					result[loop] = i;
					break;
				}
			}
			loop++;
		}

		for (long l : result) {
			System.out.println(l);
		}

	}

	private static boolean checkPalindrom(long number) {
		boolean isPalindrom = true;
		String str = number + "";
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (!(charArray[i] == charArray[charArray.length - 1 - i])) {
				isPalindrom = false;
				break;
			}
		}
		return isPalindrom;
	}

}

class Reader {

	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String readLine() throws IOException {
		byte[] buf = new byte[64]; // line length
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = read()) >= '0' && c <= '9');

		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();

		do {
			ret = ret * 10 + c - '0';
		}
		while ((c = read()) >= '0' && c <= '9');

		if (c == '.') {
			while ((c = read()) >= '0' && c <= '9') {
				ret += (c - '0') / (div *= 10);
			}
		}

		if (neg)
			return -ret;
		return ret;
	}

	public char nextChar() throws IOException {
		byte c = read();
		while (c <= ' ')
			c = read();
		return (char) c;
	}

	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}
