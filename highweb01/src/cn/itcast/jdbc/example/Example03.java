package cn.itcast.jdbc.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Example03 {

	public static void main(String[] args) throws SQLException {
		CallableStatement cst = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.22.132:3306/chapter01";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			cst = conn.prepareCall("call add_proc(?,?,?)");
			cst.setInt(1, 4);
			cst.setInt(2, 5);
			//注册CallableStatement的第三个参数为int类型
			cst.registerOutParameter(3, Types.INTEGER);
			//执行存储过程
			cst.execute();
			System.out.println("执行结果是：" + cst.getInt(3));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (cst != null) {
				cst.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
