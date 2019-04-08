package com.itheima.ioc;

public class UserServiceImpl implements UserService {

	private UserDao UserDao;
	
	public void setUserDao(UserDao userDao) {
		this.UserDao = userDao;
	}
	
	@Override
	public void say() {
		this.UserDao.say();
		System.out.println("userService say hello world!");
	}

}
