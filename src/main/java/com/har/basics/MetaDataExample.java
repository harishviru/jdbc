package com.har.basics;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.har.util.ConnectionUtils;

public class MetaDataExample {

	public static void main(String[] args) throws SQLException {
		
		  Connection con =ConnectionUtils.getConnection();

		  DatabaseMetaData metaData = con.getMetaData();
		  
		  System.out.println(metaData.getDatabaseProductName());
		  System.out.println(metaData.getDatabaseProductVersion());
		  System.out.println(metaData.getDriverName());
		  System.out.println(metaData.getDriverVersion());

		  System.out.println(metaData.getUserName());
		  System.out.println(metaData.getSQLKeywords());


		con.close();
		
	}
	
}
