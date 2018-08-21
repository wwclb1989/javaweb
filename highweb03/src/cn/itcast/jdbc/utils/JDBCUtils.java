package cn.itcast.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
	
	private static DataSource ds = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return ds;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = threadLocal.get();
		if (conn == null) {
			conn = ds.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
	
	//开启事务
	public static void startTransaction() {
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//提交事务
	public static void commit() {
		try {
			Connection conn = threadLocal.get();
			if (conn != null) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//回滚事务
	public static void rollback() {
		try {
			Connection conn = threadLocal.get();
			if (conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭数据库连接，释放资源
	public static void close() {
		Connection conn = threadLocal.get();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				threadLocal.remove();
				conn = null;
			}
		}
	}
}
