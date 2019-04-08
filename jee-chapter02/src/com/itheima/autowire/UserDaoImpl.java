package com.itheima.autowire;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("userDao...save...");
	}

}
