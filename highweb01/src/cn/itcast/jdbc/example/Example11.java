package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class Example11 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "insert into users(name,password,email,birthday)"
					+ "values(?,?,?,?)";
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < 5; i++) {
				pst.setString(1, "name" + i);
				pst.setString(2, "password" + i);
				pst.setString(3, "email" + i + "@itcast.cn");
				pst.setDate(4, Date.valueOf("1989-02-19"));
				pst.addBatch();
			}
			pst.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
