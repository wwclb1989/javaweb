package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example01 {

	public static void main(String[] args) throws Exception {
		//1.注册驱动程序
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//2.通过DriverManager获取数据库连接
		String url = "jdbc:mysql://192.168.22.132:3306/chapter01";
		String username = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, username, password);
		//3.通过Connection对象获取Statement对象
		Statement stmt = conn.createStatement();
		//4.使用Statement执行SQL语句
		String sql = "select * from users";
		ResultSet rs = stmt.executeQuery(sql);
		//5.操作ResultSet结果集
		System.out.println("id|name|password|email|birthday");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String pwd = rs.getString("password");
			String email = rs.getString("email");
			Date birthday = rs.getDate("birthday");
			System.out.println(id + "|" + name + "|" + pwd + "|" + email + "|" + birthday);
		}
		//6.回收数据库资源
		rs.close();
		stmt.close();
		conn.close();
	}
}
