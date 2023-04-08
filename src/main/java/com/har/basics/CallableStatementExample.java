package com.har.basics;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.har.util.ConnectionUtils;

public class CallableStatementExample {

	//For Checking create procedure sql script
	public static final String GET_EMP_FULL_NAME_EMPID_BY_PROCEDURE="CREATE PROCEDURE getEmpNameById("
			+ " IN  empId INT, 	OUT eName VARCHAR(25) ) "
			+ "BEGIN 	 select concat(e.first_name,' ',e.last_name) as fullName into eName from demo.employee e where e.id =empId;  "
			+ "END";

	
	private static final String CALL_PROCEDURE ="call  getEmpNameById(?,?)";
	
	public static void main(String[] args) throws SQLException {
		//#01 :(ROAD)
		  Connection con =ConnectionUtils.getConnection();
		  
     //#02 :Vehicle 
		 CallableStatement cst=con.prepareCall(CALL_PROCEDURE);  //call  getEmpNameById(?,?)
		 
		 cst.setInt(1, 200);               //input 
		 cst.registerOutParameter(2, Types.VARCHAR); //output
		 cst.execute();
		 
		 System.out.println(cst.getString(2));
		 
		//close con
		 con.close();
	}
}
