package com.har.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExampleOne {

	public static final String FIND_ALL_EMP_DETAILS = "Select * from emp";

	public static void main(String[] args) {
		ResultSet rs         = null;
		Connection con = null;
		Statement stmt  = null;
		try {
			// #01 . Load the driver and register with DriverManager
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// #02 Establish Connection b/w Java Application and Database (Road)
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/ORCL", "oharish", "manager");

			// #03.Create Statement Object (Vehicle)
			stmt = con.createStatement();

			// #04 .Send and Execute SQL Query (Input to Vehicle as SQL query..etc)
			rs = stmt.executeQuery("Select * from emp  ");

			// 05: Process Results from ResultSet

			while (rs.next()) {
				System.out.println(rs.getInt(1)          + "   \t        " + rs.getInt("EMPNO"));
				//System.out.println(rs.getString(2)  + "     \t        " + rs.getString("ENAME"));
				//System.out.println(rs.getString(3)  + "        \t       " + rs.getString("job"));
				System.out.println("+++++++++++++++++++++++++++++++");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			// 06 : close Resultset ,Statement , Connnection
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}

				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
