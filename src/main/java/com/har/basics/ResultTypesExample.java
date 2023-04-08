package com.har.basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.har.util.ConnectionUtils;

public class ResultTypesExample {

	public static void main(String[] args) throws SQLException {
		 Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    
		    //#03 : Input to Vehicle
		    ResultSet rsOne=  stmt.executeQuery("select * from employee limit 10");
		 
		    System.out.println(rsOne.getConcurrency());
		   
		    
		      System.out.println("Forward...............");
		      //#04 : Proccess the Result Set
		        while(rsOne.next()) {
		        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
		        }
		    
		    	rsOne.afterLast();;
		        System.out.println("From backward................");
		        while(rsOne.previous()) {
		        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
		        }
		    
		        rsOne.absolute(5);
		        System.out.println(" 5th ");
	        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
	        
	        	
	        	rsOne.first();
	            System.out.println(" 1st ");
	        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
	        
	        	System.out.println(rsOne.isFirst());
	        	
	        	rsOne.absolute(7);
	        	
	        	rsOne.relative(3);
	        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));

	        	//rsOne.relative(-3);
	        	//System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));

	     
		        //#05 : close the connection
		         con.close();
	}
	
}
