/**
 * 
 */
package com.hackerearth.sep18;

/**
 * @author ankur.mahajan
 * @written 14-Sep-2018
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class HackerEarthTemplateForLowMemory {

	static long[] getLongArray(String[] array) {

		long[] rate = new long[array.length];
		int i = 0;

		for (String s : array) {
			rate[i++] = Long.parseLong(s);
		}

		return rate;
	}

	public static void main(String args[]) throws Exception {

		Reader reader = new Reader();
		int t = reader.nextInt();

		for (int i = 0; i < t; i++) {
			int n = reader.nextInt();

			String readLine = reader.readLine();
			System.out.println(readLine);
			long[] rate = new long[n];
			for (int x = 0; x < n; x++) {
				rate[x] = reader.nextLong();
			}

			long cr = rate[0];
			long total = 0;

			for (int x = 0; x < n; x++) {
				long c = reader.nextLong();

				if (rate[x] < cr) {
					cr = rate[x];
				}

				total += c * cr;
			}

			System.out.println(total);

		}

		reader.close();

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
