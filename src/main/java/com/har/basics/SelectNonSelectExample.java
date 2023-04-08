package com.har.basics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.har.util.ConnectionUtils;

public class SelectNonSelectExample {

	public static final String FIND_ALL_EMP_DETAILS="Select * from employee limit 10";
	
	public static final String UPDATE_LAST_NAME="update employee set last_name='ST_8' where first_name='Ketty' ";
		
	  public static void main(String[] args) throws SQLException {
		  //Case :#01
		  //selectOperation();
	   	  //nonSelectOperation();
		 // selectAndNonSelectOperations();
		  
		  //case :#02
		  // executeQuery() Vs Non-select query
		  //executeQueryVsNonSelectOperation;
		  
		//case :#03
		//executeUpdateVsSelectOperation;
		//executeUpdateVsSelectOperation();
		  
		  //case :#04 (Create table with executeUpdate)
		  //executeUpdateWithCreateTabScript();
		  
		  
		  //One statement With One ResultSet
		  oneStatementPerResult();
		  
		  
	}

	private static void oneStatementPerResult() throws SQLException {
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		    
		    //#03 : Input to Vehicle
		    ResultSet rsOne=  stmt.executeQuery(FIND_ALL_EMP_DETAILS);
		    
		    System.out.println(rsOne.isClosed());
		    
		    //#03 : Input to Vehicle
		    ResultSet rsTwo=  stmt.executeQuery("Select * from employee where id=10");
		    
		    System.out.println(rsOne.isClosed());
		    
		    System.out.println(rsTwo.isClosed());

		    
		      //#04 : Proccess the Result Set
		        while(rsOne.next()) {
		        	System.out.println(rsOne.findColumn("first_name") +" :"+rsOne.getString("first_name") +" : "+ rsOne.findColumn("email")+": "+   rsOne.getString("email"));
		        }
		    
		        //#05 : close the connection
		         con.close();
	}

	private static void executeUpdateWithCreateTabScript() throws SQLException {
		String student_tab_query ="CREATE TABLE  Student(sid INT NOT NULL,sName VARCHAR(20) DEFAULT NULL,schoolName VARCHAR(20) DEFAULT NULL) ";
		  
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		  
		    //#03 : Input to Vehicle
		    int count=  stmt.executeUpdate(student_tab_query);  
		    
		    System.out.println("No of records count :"+count);
		    
		    //#04 : close the connection
	         con.close();
	}

	private static void executeUpdateVsSelectOperation() throws SQLException {
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		  
		    //#03 : Input to Vehicle
		    int count=  stmt.executeUpdate(FIND_ALL_EMP_DETAILS);  //Exception in thread "main" java.sql.SQLException: Statement.executeUpdate() or Statement.executeLargeUpdate() cannot issue statements that produce result sets.
		    
		    System.out.println("No of records count :"+count);
		    
		    //#04 : close the connection
	         con.close();
	}

	private static void executeQueryVsNonSelectOperation() throws SQLException {
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		    
		    ResultSet rs=stmt.executeQuery(UPDATE_LAST_NAME);    //Exception in thread "main" java.sql.SQLException: Statement.executeQuery() cannot issue statements that do not produce result sets.
		    
		    //#03 :: process the resultset
		    while(rs.next()) {
	        	System.out.println(rs.getString("first_name") +" :     "+ rs.getString("email"));
	        }
		    
		    //#04 : close the connection
	         con.close();
	}

	  // execute ? select(true)  :Non-select (false)
	private static void selectAndNonSelectOperations() throws SQLException {
		boolean resultFlag   =false;
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		    
		     resultFlag =stmt.execute(FIND_ALL_EMP_DETAILS);
		    
		    System.out.println("resultFlag    - (Select)      :"+resultFlag);
		    
		    if(resultFlag) {
		    	 System.out.println("Select Query ");
		    	 ResultSet rs=stmt.getResultSet();
		    	 while(rs.next()) {
			        	System.out.println(rs.getString("first_name") +" :     "+ rs.getString("email"));
			        }
		    }else {
		    	System.out.println("Non-Select Query ");
		    	int count = stmt.getUpdateCount();
			    System.out.println("count :"+count);
		    }
		    
		    resultFlag =stmt.execute(UPDATE_LAST_NAME);
		    
		    System.out.println("resultFlag    - (Non-Select)      :"+resultFlag);
		    
		    if(resultFlag) {
		    	 System.out.println("Select Query ");
		    	 ResultSet rs=stmt.getResultSet();
		    	 while(rs.next()) {
			        	System.out.println(rs.getString("first_name") +" :     "+ rs.getString("email"));
			        }
		    }else {
		    	System.out.println("Non-Select Query ");
		    	int count = stmt.getUpdateCount();
			    System.out.println("count :"+count);
		    }
		    
		    //#04 : close the connection
	         con.close();
	}

    //non-select :: executeUpdate
	private static void nonSelectOperation() throws SQLException {
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		  
		    //#03 : Input to Vehicle
		    int count=  stmt.executeUpdate(UPDATE_LAST_NAME);
		    
		    System.out.println("No of records count :"+count);
		    
		    //#04 : close the connection
	         con.close();
	}

    //select     : executeQuery
	private static void selectOperation() throws SQLException {
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
		  //#02 : (Vehicle)
		    Statement stmt=con.createStatement();
		    
		    //#03 : Input to Vehicle
		    ResultSet rs=  stmt.executeQuery(FIND_ALL_EMP_DETAILS);
		    
		      //#04 : Proccess the Result Set
		        while(rs.next()) {
		        	System.out.println(rs.getString("first_name") +" :"+ rs.getString("email"));
		        }
		    
		        //#05 : close the connection
		         con.close();
	}
	
}
