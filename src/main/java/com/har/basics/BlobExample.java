package com.har.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.har.util.ConnectionUtils;

public class BlobExample {

	public static void main(String[] args) throws SQLException, ParseException, IOException {
		
		//storingBlob();
		//retrieveBlobFromDB();
		
		
		
	}


	private static void retrieveBlobFromDB() throws FileNotFoundException, SQLException, IOException {
		FileOutputStream fos =new FileOutputStream("db_budha.png");
		
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement("Select * from student where sid =? ");
		ps.setInt(1, 3090);

		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
		    InputStream is = rs.getBinaryStream(5);
		    byte[] byteArray = is.readAllBytes();
		    fos.write(byteArray);
		    fos.flush();
		}
		System.out.println(" image retrieved successfully from DB");
		fos.close();
		con.close();
	}

	
	//alt+shift+M     : To grap the code into a sperate method
	private static void storingBlob() throws SQLException, ParseException, FileNotFoundException {
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?,?)");

		ps.setInt(1, 3090);
		ps.setString(2, "Budha");
		ps.setString(3, "Budha school");
		// set Date value
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date uDate = sdf.parse("2022-10-01");
		java.sql.Date dbDate = new java.sql.Date(uDate.getTime());
		ps.setDate(4, dbDate);

		// Set blob data
		// create a file point to image
		File imageFile = new File("budha.png");
		// create FileInputStream pointing File
		FileInputStream fis = new FileInputStream(imageFile);

		ps.setBinaryStream(5, fis);

		int updateCount = ps.executeUpdate();

		System.out.println("updateCount :" + updateCount);

		con.close();
	}

}
