package com.har.basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.har.util.ConnectionUtils;

public class ExampleThree {

	public static final String FIND_ALL_EMP_DETAILS="Select * from employee limit 10";

	public static void main(String[] args) throws SQLException {
		//closingResourcesWithoutTryWith();       
		//resourceOftryWithResource(); 
		
	}


	private static void resourceOftryWithResource() {
		try( Connection con =ConnectionUtils.getConnection(); Statement stmt=con.createStatement();ResultSet  rsOne=  stmt.executeQuery(FIND_ALL_EMP_DETAILS);) {
			      //# Proccess the Result Set
			        while(rsOne.next()) {
			        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
			        }
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}


	private static void closingResourcesWithoutTryWith() throws SQLException {
		Connection con  =null;
		Statement stmt   =null;
		ResultSet rsOne  =null;
		
   try {
		//#01 :(ROAD)
		   con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		     stmt=con.createStatement();
		    
		    //#03 : Input to Vehicle
		     rsOne=  stmt.executeQuery(FIND_ALL_EMP_DETAILS);
		    
		      //#04 : Proccess the Result Set
		        while(rsOne.next()) {
		        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
		        }
		    
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("closing resources ....!");
			   if(rsOne!=null &&  !rsOne.isClosed()) {
				   rsOne.close();      //closing RS object
			   }
			   if(stmt!=null && !stmt.isClosed()) {
				   stmt.close();      //closing Statement obj
			   }
			   if(con!=null && !con.isClosed()) {
				   con.close();          //closing connection obj
			   }
		}
	}
		
	
}
