package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example02 {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.22.132:3306/chapter01";
			String username = "root";
			String password = "root";
			//创建应用程序与数据库连接的Connection对象
			conn = DriverManager.getConnection(url, username, password);
			String sql = "insert into users(name,password,email,birthday) values (?,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "zl");
			pst.setString(2, "123456");
			pst.setString(3, "zl@sina.com");
			pst.setString(4, "1789-12-23");
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				pst.close();
				pst = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		}
	}
	
}
