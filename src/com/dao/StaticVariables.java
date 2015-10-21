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

}
