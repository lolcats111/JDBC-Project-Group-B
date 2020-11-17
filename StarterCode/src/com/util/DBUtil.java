package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection createConnection() {
		
		Connection cn=null;
		try {
			//Step 1: Initialize the jdbc driver.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Step 2: Create a Connection object
			cn=DriverManager.getConnection("jdbc:oracle:thin:@intvmoradb04.india.tcs.com:1521:JAVADB", "RESCHEDULE_DEV", "tcstvmrsch");
			
		} catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return cn;
	}
	
	public static void closeAllConnection(Connection cn, PreparedStatement ps, ResultSet rs) {
		try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(cn!=null) {
					cn.close();
				}
		} catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
