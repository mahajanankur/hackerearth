package com.java.miscellaneous;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {

	/**
	 * @param args
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:1521/MY_DB";

	// Database credentials
	static final String USER = "MY_DB";
	static final String PASS = "mydb";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String query = "select * from app_user";
			ResultSet set = stmt.executeQuery(query);

			// STEP 5: Extract data from result set
			while (set.next()) {
				// Retrieve by column name
				int id = set.getInt("id");
				String user = set.getString("username");
				String pw = set.getString("password");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", UserName: " + user);
				System.out.println(", Password: " + pw);
			}
			// STEP 6: Clean-up environment
			set.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
		// end FirstExample

}
