package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 需要三个jar包,common-dbcp2-2.5.0.jar,依赖包commons-pool2-2.6.0.jar,commons-logging-1.2.jar
 * @author wl
 *
 */
public class Example02 {

	public static DataSource ds = null;
	
	static {
		//获取DBCP数据源实现类对象
		BasicDataSource bds = new BasicDataSource();
		//设置连接数据库需要的配置信息
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://192.168.22.132:3306/chapter02");
		bds.setUsername("root");
		bds.setPassword("root");
		//设置连接池的参数
		bds.setInitialSize(5);
		//新方法？setMaxActive
		bds.setMaxTotal(5);
		ds = bds;
	}
	
	public static void main(String[] args) throws SQLException {
		
		//获取数据库连接对象
		Connection conn = ds.getConnection();
		//获取数据库连接信息
		DatabaseMetaData metaData = conn.getMetaData();
		//打印数据库连接信息
		System.out.println(metaData.getURL() + ",UserName=" + metaData.getUserName() + "," + metaData.getDriverName());
	}

}
