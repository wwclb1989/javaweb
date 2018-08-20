package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class Example10 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql1 = "drop table if exists school";
			String sql2 = "create table school(id int,name varchar(20))";
			String sql3 = "insert into school values(2,'传智播客')";
			String sql4 = "update school set id=1";
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			stmt.addBatch(sql4);
			stmt.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.release(stmt, conn);
		}
	}
}
