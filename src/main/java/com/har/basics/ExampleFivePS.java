package com.har.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.har.util.ConnectionUtils;

public class ExampleFivePS {

	public static final String UPDATE_LAST_NAME="update employee set last_name=? where first_name=?";
	
	public static void main(String[] args) throws SQLException {
		
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
       //#02 :Vehicle 
		  PreparedStatement ps=con.prepareStatement(UPDATE_LAST_NAME);
		  
		  //#03 : set the values to positional params
		   ps.setString(1, "Viru 123");
		   ps.setString(2, "Jock");
		   
		   //#04 : call  respective execute Method  :: non-select ? executeUpdate      
		   int count =ps.executeUpdate();
		
		   System.out.println("count    :"+count);
		
		 //#05 : finally close connection
		   
		   con.close();
		
	}
}
