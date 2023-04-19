package com.har.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicExampleOne {

	public static final String FIND_ALL_EMP_DETAILS = "Select * from employee ";

	public static final String TAB_SPACE = "\t     ";

	public static void main(String[] args) {
		Connection con = null;
		// #01.Load and Register Driver with DriverManager
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver");

			// #02.Establish Connection b/w Java Application and Database (Road)
			 con = DriverManager.getConnection("jdbc:mysql://localhost : 3306 /demo", "root", "root");

			// 03)Create Statement Object (Vehicle)
			Statement stmt = con.createStatement();

			// 04)Send and Execute SQL Query (Input to Vehicle as SQL query..etc)
			ResultSet rs = stmt.executeQuery(FIND_ALL_EMP_DETAILS);

			// 05)Process Results from ResultSet

			while (rs.next()) {
				System.out.println(rs.getInt("id") + TAB_SPACE + rs.getString(2) + TAB_SPACE + rs.getString(3));
			}
		} catch ( Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close(); //06 .close connection
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
