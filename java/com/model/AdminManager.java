package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminManager {
	String url = "jdbc:mysql://localhost:3306/klu";
	String username = "root";
	String password = "2100031563@kluniversity.in"; //MySQL DB Password
	String mysqldriver = "com.mysql.cj.jdbc.Driver";
	
	
	Connection con = null;
	PreparedStatement stmt = null;
	
	public String addpro(Addpro U)throws Exception
	{
		Class.forName(mysqldriver);
		con = DriverManager.getConnection(url, username, password);
		stmt = con.prepareStatement("insert into admin values(?,?,?,?)");
		stmt.setString(1,U.getName());
		stmt.setString(2,U.getQty());
		stmt.setString(3,U.getType());
		stmt.setString(4,U.getCost());
		stmt.execute();
		con.close();
		return "Product inserted successfully";
		
	}
}

