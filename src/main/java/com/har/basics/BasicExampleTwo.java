package com.har.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.har.dbenum.DBCredentials;

public class BasicExampleTwo {

	public static final String FIND_ALL_EMP_DETAILS="Select * from employee limit 10";
	
	public static final String TAB_SPACE="\t     ";
	
	public static void main(String[] args) throws Exception {
		
		//#01.Load and Register Driver with DriverManager
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		//#02.Establish Connection b/w Java Application and Database  (Road)
		Connection con=DriverManager.getConnection(DBCredentials.URL.getName(),DBCredentials.USER_NAME.getName(),DBCredentials.USER_NAME.getName());
		
		//03)Create Statement Object    (Vehicle)
		    Statement stmt=       con.createStatement();
		                                   
		//04)Send and Execute SQL Query (Input to Vehicle as SQL query..etc)
		    ResultSet   rs    =   stmt.executeQuery(FIND_ALL_EMP_DETAILS);
		
		    //05)Process Results from ResultSet
		    
		      while(rs.next()) {
		    	  System.out.println(rs.getInt("id") + TAB_SPACE + rs.getString(2) + TAB_SPACE + rs.getString(3));
		      }
		      
		    // 6)Close the connection
		      con.close();
	}
	
}
