package cn.itcast.jdbc.example.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.example.domain.User;

public class ResultSetTest3 {
	
	public static void testBeanHandler() {
		BaseDao basedao = new BaseDao();
		String sql = "select * from user where id=?";
		User user = (User) basedao.query(sql, new BeanHandler(User.class), 1);
		System.out.println("id为1的User对象的name值为:" + user.getName());
	}
	
	public static void main(String[] args) {
		testBeanHandler();
	}
}
