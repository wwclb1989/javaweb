package cn.itcast.jdbc.example.dao;

import java.sql.SQLException;

import cn.itcast.jdbc.example.domain.User;

public class DBUtilsDaoTest1 {

	private static DBUtilsDao dao = new DBUtilsDao();
	
	public static void main(String[] args) throws SQLException {
		User user = new User();
		
		user.setName("zhaoliu");
		user.setPassword("666666");
		boolean b = dao.insert(user);
		System.out.println(b);
	}
	
}
