package cn.itcast.test;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.util.HibernateUtil;

public class UserTest {

	@Test
	public void test1(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		User user=(User) session.get(User.class, 1);
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getAge());
		tx.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		User user=(User) session.get(User.class, 1,LockMode.UPGRADE);
		user.setUsername("Tom");
		session.save(user);
		tx.commit();
		session.close();
	}
	
	@Test
	public void test3(){
		Session session=HibernateUtil.getSession();
		Transaction tx=session.beginTransaction();
		User user=(User) session.get(User.class, 1,LockMode.UPGRADE);
		user.setAge(30);
		session.save(user);
		tx.commit();
		session.close();
	}
}
