package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class userManager {
	String url = "jdbc:mysql://localhost:3306/klu";
	String username = "root";
	String password = "2100031563@kluniversity.in"; //MySQL DB Password
	String mysqldriver = "com.mysql.cj.jdbc.Driver";
	
	
	Connection con = null;
	PreparedStatement stmt = null;
	
	public String ValidateCredentials(Users U)throws Exception
	{
		Class.forName(mysqldriver);
		con =DriverManager.getConnection(url,username,password);
		stmt=con.prepareStatement("select username from klu.users where username=? and password=? ");
		stmt.setString(1,U.getUsername());
		stmt.setString(2,U.getPassword());
		ResultSet rs=stmt.executeQuery();
		String res="";
		
		if(rs.next()) 
			res=rs.getString(1);
		
		con.close();
		return res;
		
	}
	
	public String saveData(Users U)throws Exception
	{
		Class.forName(mysqldriver);
		con = DriverManager.getConnection(url, username, password);
		stmt = con.prepareStatement("insert into Users values(?,?,?,?)");
		stmt.setString(1, U.getUsername());
		stmt.setString(2, U.getPassword());
		stmt.setString(3,U.getName());
		stmt.setString(4,U.getMobile());
		stmt.execute();
		con.close();
		return "Record inserted successfully";
		
	}
}
