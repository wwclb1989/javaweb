package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.domain.Customer;

public class CustomerTest {

	public void insertTest(){
		//1.加载hibernate.cfg.xml配置
		Configuration config=new Configuration().configure();
		//2.获取Sessionfactory
		SessionFactory sessionFactory=config.buildSessionFactory();
		//3.得到一个Session
		Session session=sessionFactory.openSession();
		//4.开启事务
		Transaction t=session.beginTransaction();
		//5.操作
		Customer c=new Customer();
		c.setName("王五");
		c.setAge(20);
		c.setCity("上海");
		c.setSex("男");
		//5.2将数据存储到表中
		session.save(c);
		//6.提交事务
		t.commit();
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}
	
	public void updateTest(){
		//1.加载hibernate.cfg.xml配置
		Configuration config=new Configuration().configure();
		//2.获取SessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory();
		//3.得到一个Session
		Session session=sessionFactory.openSession();
		//4.开启事务
		Transaction t=session.beginTransaction();
		//5.操作
		Customer c=new Customer();
		c.setId(1);
		c.setName("李四");
		c.setAge(20);
		c.setSex("男");
		c.setCity("广州");
		session.update(c);
		//6.提交事务
		t.commit();
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}
	
	public void findByIdTest(){
		//1.加载hibernate.cfg.xml配置
		Configuration config=new Configuration().configure();
		//2.获取SessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory();
		//3.得到一个Session
		Session session=sessionFactory.openSession();
		//4.开启事务
		Transaction t=session.beginTransaction();
		//5.操作
		//对于hibernate中根据id的查找操作,可以使用两个方法get(),load()
		Customer c=(Customer) session.get(Customer.class, 1);
		//Customer c=(Customer)session.load(Customer.class,1);
		System.out.println("姓名:"+c.getName());
		System.out.println("年龄:"+c.getAge());
		System.out.println("性别:"+c.getSex());
		System.out.println("所在城市:"+c.getCity());
		//6.提交事务
		t.commit();
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}
	
	public void deleteByIdTest(){
		//1.加载hibernate.cfg.xml配置
		Configuration config=new Configuration().configure();
		//2.获取SessionFactory
		SessionFactory sessionFactory=config.buildSessionFactory();
		//3.得到一个Session
		Session session=sessionFactory.openSession();
		//4.开启事务
		Transaction t=session.beginTransaction();
		//5.操作
		Customer c=(Customer) session.get(Customer.class, 2);	//先查询
		session.delete(c);										//再删除
		//6.提交事务
		t.commit();
		//7.关闭资源
		session.close();
		sessionFactory.close();
	}
}
