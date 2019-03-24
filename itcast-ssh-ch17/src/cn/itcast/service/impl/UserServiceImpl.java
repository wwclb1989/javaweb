package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		this.userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		this.userDao.update(user);
	}

	@Override
	public void deleteUser(User user) {
		this.userDao.delete(user);
	}

	@Override
	public User findUserById(Integer id) {
		return this.userDao.findById(id);
	}

	@Override
	public List<User> findAllUser() {
		return this.userDao.findAll();
	}

}
