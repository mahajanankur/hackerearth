package com.java.miscellaneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

	/**
	 * @param args
	 * @return
	 */
	// public static void main(String[] args) {
	// DtoForTable1 dto = new DtoForTable1();
	// JDBC(dto);
	//
	// }

	public List<DtoForTable1> JDBC() {
		List<DtoForTable1> list = new ArrayList<DtoForTable1>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", "MY_DB", "mydb");
			Statement stmt = con.createStatement();
			String query = "select * from table1";
			ResultSet set = stmt.executeQuery(query);

			while (set.next()) {
				DtoForTable1 dto = new DtoForTable1();
				dto.setId(set.getInt("id"));
				dto.setName(set.getString("name"));
				dto.setMobile(set.getLong("mobile"));
				dto.setProfession(set.getString("profession"));
				dto.setSalary(set.getInt("salary"));
				dto.setAddress(set.getString("address"));
				list.add(dto);
			}
			set.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
