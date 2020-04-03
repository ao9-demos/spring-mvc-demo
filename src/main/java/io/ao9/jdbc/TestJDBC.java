package io.ao9.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC{
    public static void main (String[] args) {
        String jdbcUrl = "jdbc:mysql://34.74.126.132:3306/hb-01-one-to-one-uni?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
        
        try {
            System.out.println("connecting: "+jdbcUrl);
            Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successful");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}