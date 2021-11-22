package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.DbConst;

public class MySQLConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DbConst.MYSQL_URL, DbConst.USERNAME, DbConst.PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Khong tim thay driver MySQL Connection J.");
		} catch (SQLException e) {
			System.out.println("Khong ket noi duoc");
			e.printStackTrace();
		}
		return null;
	}
}
