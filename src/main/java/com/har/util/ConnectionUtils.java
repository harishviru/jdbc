package com.har.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import com.har.dbenum.DBCredentials;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionUtils {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBCredentials.URL.getName(), DBCredentials.USER_NAME.getName(),
				DBCredentials.USER_NAME.getName());
	}

	public static DataSource getDataSource() {
		MysqlDataSource ds = new MysqlConnectionPoolDataSource();
		// set JDBC props
		ds.setUrl(DBCredentials.URL.getName());
		ds.setUser(DBCredentials.USER_NAME.getName());
		ds.setPassword(DBCredentials.USER_NAME.getName());
		System.out.println("DataSource     "+ds);
		return ds;
	}

	//Getting Connection from Mysql Connection Pool
	public static Connection getConnectionFromDs() throws SQLException {
		return getDataSource().getConnection();
	}

}
