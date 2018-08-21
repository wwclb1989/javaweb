package cn.itcast.jdbc.example.dao;

import java.sql.SQLException;

import cn.itcast.jdbc.example.domain.User;

public class DBUtilsDaoTest2 {

	private static DBUtilsDao dao = new DBUtilsDao();
	
	public static void testUpdate() throws SQLException {
		User user = new User();
		user.setName("zhaoliu");
		user.setPassword("666777");
		user.setId(4);
		boolean b = dao.update(user);
		System.out.println(b);
	}
	
	public static void main(String[] args) throws SQLException {
		testUpdate();
	}
}
