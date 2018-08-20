package cn.itcast.jdbc.example;

import java.util.Date;

import cn.itcast.jdbc.example.dao.UserDao;
import cn.itcast.jdbc.example.domain.User;

public class Example05 {

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		User user = new User();
		user.setId(5);
		user.setUsername("hl");
		user.setPassword("123");
		user.setEmail("hl@sina.com");
		user.setBirthday(new Date());
		boolean b = ud.insert(user);
		System.out.println(b);
	}

}
