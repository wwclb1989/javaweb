package cn.itcast.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateTest {

	public void createTableTest() {
		
		String xmlPath = "cn/itcast/jdbc/JdbcTemplateBeans.xml";
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		JdbcTemplate jdTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
		
		jdTemplate.execute("create table t_user("
				+ "userid number primary key,"
				+ "username varchar2(50),"
				+ "password varchar2(32))");
	}
	
	public void addUserTest() {
		//定义配置文件路径
		String xmlPath = "cn/itcast/jdbc/JdbcTemplateBeans.xml";
		//创建spring容器,加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		User user = new User();
		user.setUsername("jack");
		user.setPassword("1234");
		
		int flag = userDao.addUser(user);
		
		if(flag == 1) {
			System.out.println("添加用户成功!");
		} else {
			System.out.println("添加用户失败!");
		}
	}
	
	//更新数据
	public void updateUserTest() {
		//定义配置文件路径
		String xmlPath = "cn/itcast/jdbc/JdbcTemplateBeans.xml";
		//创建spring容器,加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		User user = new User();
		user.setUserid(1);
		user.setUsername("tom");
		user.setPassword("1111");
		
		int flag = userDao.updateUser(user);
		
		if(flag == 1) {
			System.out.println("修改用户成功!");
		} else {
			System.out.println("修改用户失败!");
		}
		
	}
	
	//删除数据
	public void deleteUserTest() {
		//定义配置文件路径
		String xmlPath = "cn/itcast/jdbc/JdbcTemplateBeans.xml";
		//创建spring容器,加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		int flag = userDao.deleteUserById(1);
		
		if(flag == 1) {
			System.out.println("删除用户成功!");
		} else {
			System.out.println("删除用户失败!");
		}
	}
	
	//根据id查找用户
	@Test
	public void findUserByIdTest() {
		//定义配置文件路径
		String xmlPath = "cn/itcast/jdbc/JdbcTemplateBeans.xml";
		//创建spring容器,加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		User user = userDao.findUserById(2);
		
		System.out.println(user);
	}
	
	//查找所有用户
	public void findAllUserTest() {
		//定义配置文件路径
		String xmlPath = "cn/itcast/jdbc/JdbcTemplateBeans.xml";
		//创建spring容器,加载配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		List<User> users = userDao.findAllUser();
		
		for (User user : users) {
			System.out.println(user);
		}
	}
}
