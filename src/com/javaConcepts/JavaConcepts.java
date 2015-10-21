package com.javaConcepts;

import com.dao.StaticVariables;

public class JavaConcepts {

	public static void main(String[] args) {
		StaticVariables sv = new StaticVariables();
//		StaticVariables.setCollege("Nit Hamirpur");
		sv.setCollege("NITH");
		sv.setStudentName("Ankur Mahajan");
		System.out.println("Student Name : " + sv.getStudentName());
		System.out.println("College Name by class ref : " + sv.getCollege());
		System.out.println("College Name by class Name : "
				+ StaticVariables.getCollege());
		
		StaticVariables sv1 = new StaticVariables();
		System.out.println("Student Name : " + sv1.getStudentName());
		System.out.println("College Name by class ref : " + sv1.getCollege());
		System.out.println("College Name by class Name : "
				+ StaticVariables.getCollege());

	}

}
