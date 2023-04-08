package com.har.basics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.har.util.ConnectionUtils;

public class HandlingDateValue {

	
	public static void main(String[] args) throws SQLException, ParseException {
		boolean flag =true;
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?)");

		  Scanner scn =new Scanner(System.in);
		
		  while(flag) {
			  System.out.println("enter id :");
			  ps.setInt(1, scn.nextInt());
			  
			  System.out.println("enter name :");
			  ps.setString(2, scn.next());
			  
			  System.out.println("enter schoolNAME :");
			  ps.setString(3, scn.next());
			  
			  System.out.println("enter DOJ  (yyyy-MM-dd) :");
			  String userDate  =scn.next();
			  
			  SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			  Date uDate =sdf.parse(userDate);
			  
			  java.sql.Date dbDate =new java.sql.Date(uDate.getTime());
			  ps.setDate(4, dbDate);
			 int count = ps.executeUpdate();
			 
			 
			 System.out.println("count     :"+count);
		       System.out.println("Select options      ::");
		       System.out.println("To Contine            :: press any value");
		       System.out.println("To stop                :: press 'N' ");
		       String option  =scn.next();
		       
		       if("N".equalsIgnoreCase(option)) {
		    	   flag=false;
		       }
		  }
		  con.close();
		  System.out.println("end main");
	}
	
}
