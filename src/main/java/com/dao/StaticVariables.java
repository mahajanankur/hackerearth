package com.dao;

public class StaticVariables {

	// public static String college = "NIT Hamirpur";

	public static String college;

	// public String studentName = "Ankur Mahajan";

	public String studentName;

	public int cls;

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		StaticVariables.college = college;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getCls() {
		return cls;
	}

	public void setCls(int cls) {
		this.cls = cls;
	}

	public static void main(String[] args) {
		int arr[] = { 25626, 25757, 24367, 24267, 16, 100, 2, 7277 };

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				System.out.println(arr[i]);
			} else {
				int delta = arr[i] - arr[i - 1];
				System.out.println(delta);
			}

		}
	}
}
