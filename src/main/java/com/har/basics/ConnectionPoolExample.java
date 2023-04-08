package com.har.basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.har.util.ConnectionUtils;

public class ConnectionPoolExample {

	public static final String FIND_ALL_EMP_DETAILS="Select * from employee limit 10";

	public static void main(String[] args) throws SQLException {

		Connection con =ConnectionUtils.getConnectionFromDs();
		
		 //#02 : (Vehicle)
	    Statement stmt=con.createStatement();
	    
	    //#03 : Input to Vehicle
	    ResultSet rsOne=  stmt.executeQuery(FIND_ALL_EMP_DETAILS);
	    
	    ResultSetMetaData rsMetaData= rsOne.getMetaData();
	    
	    System.out.println(rsMetaData.getColumnCount());
	    
	    
	    
	    
	    
	      //#04 : Proccess the Result Set
	        while(rsOne.next()) {
	        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
	        }
	    
	        //#05 : close the connection
	         con.close();
		
	}
}
