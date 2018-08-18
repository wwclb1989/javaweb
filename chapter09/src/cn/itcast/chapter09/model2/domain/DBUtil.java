package cn.itcast.chapter09.model2.domain;

import java.util.HashMap;

public class DBUtil {

	private static DBUtil instance = new DBUtil();
	private HashMap<String, UserBean> users = new HashMap<>();
	
	private DBUtil() {
		UserBean user1 = new UserBean();
		user1.setName("Jack");
		user1.setPassword("12345678");
		user1.setEmail("jack@it315.org");
		users.put("Jack", user1);
		
		UserBean user2 = new UserBean();
		user2.setName("Rose");
		user2.setPassword("abcdefg");
		user2.setEmail("rose@it315.org");
		users.put("Rose", user2);
	}
	
	public static DBUtil getInstance() {
		return instance;
	}
	
	//获取数据库(users)中的数据
	public UserBean gettUser(String userName) {
		UserBean user = users.get(userName);
		return user;
	}
	
	public boolean insertUser(UserBean user) {
		if (user == null) {
			return false;
		}
		
		
		String userName = user.getName();
		if (users.get(userName) != null) {
			return false;
		}
		
		users.put("userName", user);
		return true;
	}
}
