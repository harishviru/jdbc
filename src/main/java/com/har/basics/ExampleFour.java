package com.har.basics;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.har.util.ConnectionUtils;

public class ExampleFour {

	private static String INSERT_STUDENT = "insert into student (sid,sName,schoolName) values (204,'suman','MySchool')";

	private static String INSERT_DYNAMIC_STUDENT = "insert into student (sid,sName,schoolName) values (%d,%s,%s)";

	public static void main(String[] args) throws SQLException {

		Connection con = null;
		boolean flagIn = true;
		
		
		while (flagIn) {

			int sid = 0;
			String name = "";
			String schoolName = "";
			Scanner scn = new Scanner(System.in);

			System.out.println("Enter sId   :");
			sid = scn.nextInt();

			System.out.println("Enter sName   :");
			name = " ' "+ scn.next() +" ' ";

			System.out.println("Enter schoolName   :");
			schoolName =" ' "+  scn.next()+" ' ";

			con = ConnectionUtils.getConnection();
			Statement stmt = con.createStatement();

			String formatSQL =String.format(INSERT_DYNAMIC_STUDENT, sid,name,schoolName);
			System.out.println(formatSQL);
			
			int count = stmt.executeUpdate(formatSQL);
			System.out.println("count :" + count);
			String opt ="";
			System.out.println("Still you want create one more record , then type anything orelse Not required then type 'N' ");
			opt =scn.next();
			if("N".equalsIgnoreCase(opt)) {
				flagIn =false;
			}
		}
		if (con != null) {
			System.out.println("con closed........!");
			con.close();
		}
	}
}
