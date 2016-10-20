package com.gh.HelloSpring.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.stereotype.Component;

public class UtilsClass {

	public UtilsClass() {
		System.out.println("def contr of utils");
	}
	
	private static Connection con;

	public static Connection getConnection()
	{
		try{
			System.out.println("connection creation started");
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM", "admin");
			System.out.println("connection created");
			
			PoolProperties p=new PoolProperties();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
