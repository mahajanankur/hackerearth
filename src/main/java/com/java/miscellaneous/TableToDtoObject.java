package com.java.miscellaneous;

import java.util.List;

public class TableToDtoObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		List<DtoForTable1> tableEntries = db.JDBC();
		System.out.println(tableEntries);
	}

}
