package com.app.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Just checking out if the jdbc has been setup properly.
 * We have added Hibernate JARS and JDBC Connector jar in classpath.
 * @author user
 *
 */
public class JdbcTest {
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/college?useSSL=false" ;
		String user = "hbstudent";
		String password = "Hbstudent@123" ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
				System.out.println("Connection = "+ conn);
				
				if(conn != null && conn.isValid(20)) {
					System.out.println("connection successful");
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
