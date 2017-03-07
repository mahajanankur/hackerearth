package com.java.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestException {

	public static void main(String[] args) {
		compileTimeError();
		
	}

	private static void compileTimeError() {
		
		try {
			int array[] = new int[] { 1, 2, 3 };
			int var = array[3];
			System.out.println("In try");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			br.readLine();
		} catch (Exception e) {
			System.out.println("In Exception");
//		} catch (ArrayIndexOutOfBoundsException ae) {
//			System.out.println("ArrayIndexOutOfBoundsException");
//		} catch (IOException a) {
//			System.out.println("ArrayIndexOutOfBoundsException");
		} finally {
			System.out.println("In Finally");
		}
	}

}
