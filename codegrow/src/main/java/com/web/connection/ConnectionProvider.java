package com.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			String url = "jdbc:mariadb://127.0.0.1:3306/codegrow?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String id = "root";
			String pass = "1111";
			String driver = "org.mariadb.jdbc.Driver"; // MariaDB JDBC 드라이버 클래스
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}