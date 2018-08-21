package cn.itcast.jdbc.example;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Example05 {
	
	public static DataSource ds = null;
	//初始化c3p0数据源
	static {
		ComboPooledDataSource cpds = new ComboPooledDataSource("itcast");
		ds = cpds;
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(ds.getConnection());
	}
}
