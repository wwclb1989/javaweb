package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class Example01 {

	public static void main(String[] args) {
		String outAccount = "aaa";
		String inAccount = "bbb";
		double amount = 200;
		Connection conn = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		try {
			conn = JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			String sql1 = "update account set money=money-? where name=? and money>=200";
			pst1 = conn.prepareStatement(sql1);
			pst1.setDouble(1, amount);
			pst1.setString(2, outAccount);
			pst1.executeUpdate();
			String sql2 = "update account set money=money+? where name=?";
			pst2 = conn.prepareStatement(sql2);
			pst2.setDouble(1, amount);
			pst2.setString(2, inAccount);
			pst2.executeUpdate();
			conn.commit();
			System.out.println("转账成功！");
		} catch (Exception e) {
			try {
				conn.rollback();
				System.out.println("转账失败！");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (pst1 != null) {
				try {
					pst1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtils.release(pst2, conn);
		}
	}
}
