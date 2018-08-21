package cn.itcast.mydatasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.itcast.jdbc.example.utils.JDBCUtils;

public class JdbcPool implements DataSource {

	private static LinkedList<Connection> pool = new LinkedList<>();
	
	static {
		try {
			for (int i = 0; i < 10; i++) {
				pool.add(getNewCon());
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getNewCon() throws ClassNotFoundException, SQLException {
		return JDBCUtils.getConnection();
	}
	
	public static LinkedList<Connection> getPool() {
		return pool;
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		//返回删除的LinkedList集合中的第一个连接对象
		Connection connection = pool.removeFirst();
		//包装设计模式,包装Connection对象,重写close()方法
		MyConnection con = new MyConnection(connection, pool);
		return con;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
