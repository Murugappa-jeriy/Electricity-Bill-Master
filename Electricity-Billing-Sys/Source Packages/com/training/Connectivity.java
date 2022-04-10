package com.training;

import java.sql.*;

public class Connectivity {
	Connection c;
	Statement s;
	public Connectivity()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///asm","root","Password");
			s = c.createStatement();
			}catch(Exception e){
				System.out.println(e);
		}
	}
}
  