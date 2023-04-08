package com.har.basics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.har.util.ConnectionUtils;

public class ResullTypesExampleTwo {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {

		Connection con = ConnectionUtils.getConnection();

		// #02 : (Vehicle)
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		// #03 : Input to Vehicle
		ResultSet rsOne = stmt.executeQuery("select * from employee limit 10");

		System.out.println("Forward...............");
		// #04 : Proccess the Result Set
		while (rsOne.next()) {
			System.out.println(rsOne.findColumn("first_name") + " :" + rsOne.getString("first_name") + " : "+ rsOne.findColumn("email") + ": " + rsOne.getString("email"));
		}
		System.out.println("Application....in pause");
		//System.in.read();
		Thread.sleep(20000);
		rsOne.beforeFirst();
		System.out.println("After updation");
		while (rsOne.next()) {
			rsOne.refreshRow();
			System.out.println(rsOne.findColumn("first_name") + " :" + rsOne.getString("first_name") + " : "+ rsOne.findColumn("email") + ": " + rsOne.getString("email"));
		}

		con.close();
	}

}
