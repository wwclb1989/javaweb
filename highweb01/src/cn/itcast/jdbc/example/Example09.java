package cn.itcast.jdbc.example;

import cn.itcast.jdbc.example.dao.UserDao;

public class Example09 {

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		boolean b = ud.delete(4);
	}
}
