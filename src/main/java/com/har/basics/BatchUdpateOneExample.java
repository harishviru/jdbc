package com.har.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.har.util.ConnectionUtils;

public class BatchUdpateOneExample {
	
	public static void main(String[] args) throws SQLException {
		 //batchWithSimpleStatement();
		// batchUpdateWithPs();
		
	}



	@SuppressWarnings("unused")
	private static void batchUpdateWithPs() throws SQLException {
		boolean flag =true;
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)");

		  Scanner scn =new Scanner(System.in);
		
		  while(flag) {
			  System.out.println("enter id :");
			  ps.setInt(1, scn.nextInt());
			  
			  System.out.println("enter firstName :");
			  ps.setString(2, scn.next());
			  
			  System.out.println("enter lastName :");
			  ps.setString(3, scn.next());
			  
			  System.out.println("enter email :");
			  ps.setString(4, scn.next());
			  
			  System.out.println("enter gender :");
			  ps.setString(5, scn.next());
			  
			  System.out.println("enter ipaddress :");
			  ps.setString(6, scn.next());
			  
			  ps.addBatch();
			  
		       System.out.println("Select options      ::");
		       System.out.println("To Contine            :: press any value");
		       System.out.println("To stop                :: press 'N' ");
		       String option  =scn.next();
		       
		       if("N".equalsIgnoreCase(option)) {
		    	   flag=false;
		       }
		  }
		  
		  int count[] =ps.executeBatch();
	       for(int cValue:count) {
	    	   System.out.println(cValue);
	       }
		  con.close();
		  System.out.println("end main");
	}

	

	private static void batchWithSimpleStatement() throws SQLException {
		Connection con = ConnectionUtils.getConnection();
		Statement st = con.createStatement();

		 // adding queries to batch
		//st.addBatch("select * from employee");       // only Non-select queries otherwise :  java.sql.BatchUpdateException: S
		st.addBatch("update employee set last_name='ST_8' where first_name='Ketty' ");
		st.addBatch("INSERT INTO employee VALUES(1290, 'harish', 's', 'sharish489@gmail.com', 'Male', '221.253.39.24')");
       st.addBatch("delete from demo.employee  where id =230");
       
       int count[] =st.executeBatch();
       
       for(int cValue:count) {
    	   System.out.println(cValue);
       }
       con.close();
       System.out.println("end main");
	}
}
