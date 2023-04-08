package com.har;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FileTest {

	 String name="FILE_NAME";
	 
	 public FileTest() {
		
	}
	 public FileTest(String name) {
		 this.name=name;
	 }
	
	
	
	public static void main(String[] args) throws IOException {
		
		//create a file point to image 
		File imageFile =new File("budha.png");
		
		//create FileInputStream pointing File
		FileInputStream fis =new FileInputStream(imageFile);
		
		System.out.println(fis.read());
		
		fis.close();
		
		try {
	    	 InputStream is =new FileInputStream(new File("src/main/java/db.properties"));
	 		Properties ps =new Properties();
			ps.load(is);
			System.out.println();
			Connection con =DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("username"),ps.getProperty("password"));
			System.out.println(con.isClosed());
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
