package Dao;

import java.sql.*;


public class Conn implements DatabaseConnection {
	
	private static Connection c;
	private static Conn instance = null;
	
	
	
	private Conn(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","12345");
			
		}
	
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static Conn getInstance() {
		if (instance == null) {
			instance = new Conn();
		}
		return instance;
		
	}
	
	public  Connection getConnection() {
		return c;
	}

}