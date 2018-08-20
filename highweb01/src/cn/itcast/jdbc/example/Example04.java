package cn.itcast.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.stage.StageStyle;

public class Example04 {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.168.22.132:3306/chapter01";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from users";
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery(sql);
			System.out.print("第2条数据的name值为：");
			//将指针定位到结果集中第2行数据
			rs.absolute(2);
			System.out.println(rs.getString("name"));
			System.out.print("第1条数据的name值为：");
			//将指针定位到结果集中第1行数据之前
			rs.beforeFirst();
			//将指针向后滚动
			rs.next();
			System.out.println(rs.getString("name"));
			System.out.print("第4条数据的name值为：");
			//将指针定位到结果集中最后一条数据之后
			rs.afterLast();
			//将指针向前滚动
			rs.previous();
			System.out.println(rs.getString("name"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		}
		
	}
}
