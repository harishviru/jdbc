package com.har.basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.har.util.ConnectionUtils;

public class TransactionExample {

	public static final String UPDATE_LAST_NAME = "update employee set last_name='ST_900' where first_name='Ketty' ";

	public static final String INSERT_QUERY = "INSERT INTO employee VALUES(2908, 'OName', 'OLName', 'Male', 'your@mymail.com', '20.192.168.90')";

	public static final String FIND_ALL_EMP_DETAILS = "Select * from employee limit 10";

	public static void main(String[] args) throws SQLException {
		// #01 :(ROAD)
		Connection con = ConnectionUtils.getConnection();

		// #02 : (Vehicle)
		Statement stmt = con.createStatement();

		// #03 : Input to Vehicle
		ResultSet rsOne = stmt.executeQuery(FIND_ALL_EMP_DETAILS);

		// #04 : Proccess the Result Set
		while (rsOne.next()) {
			System.out.println(rsOne.getString("first_name") + "---" + rsOne.getString("email"));
		}

		System.out.println(con.getAutoCommit());

		// Transaction Management
		// a)Disable auto commit mode of JDBC.
		con.setAutoCommit(false);

		stmt.executeUpdate(UPDATE_LAST_NAME);

		stmt.executeUpdate(INSERT_QUERY);

		Scanner scn = new Scanner(System.in);
		System.out.println("Please provide to commit or rollbacl....? YES /anything text");
		String tOption = scn.next();

		if ("YES".equalsIgnoreCase(tOption)) {
			con.commit();
			System.out.println("transaction completed");
		} else {
			con.rollback();
			System.out.println("transaction rollbacked");
		}
		// #05 : close the connection
		con.close();
	}

}
