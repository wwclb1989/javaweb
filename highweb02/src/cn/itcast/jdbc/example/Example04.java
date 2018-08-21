package cn.itcast.jdbc.example;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example04 {

	public static DataSource ds = null;
	//初始化c3p0数据源
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
			cpds.setJdbcUrl("jdbc:mysql://192.168.22.132:3306/chapter02");
			cpds.setUser("root");
			cpds.setPassword("root");
			//设置连接池的参数
			cpds.setInitialPoolSize(5);
			cpds.setMaxPoolSize(15);
			ds = cpds;
		} catch(Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(ds.getConnection());
	}
}
