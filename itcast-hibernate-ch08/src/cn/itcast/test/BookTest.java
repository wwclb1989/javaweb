package cn.itcast.test;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.entity.Book;
import cn.itcast.utils.HibernateUtils;

public class BookTest {
	//演示持久化对象的三种状态
	public void test1(){
		//1.得到session
		Session session=HibernateUtils.getSession();
		//2.开启事务
		session.beginTransaction();
		//3.操作
		Book book=new Book();
		book.setName("think in java");
		book.setPrice(99d);
		session.save(book);
		//4.提交事务
		session.getTransaction().commit();
		//5.关闭资源
		session.close();
		System.out.println(book);
	}
	
	public void test2(){
		//1.得到session
		Session session=HibernateUtils.getSession();
		//2.开启事务
		session.beginTransaction();
		//3.操作
		//获取b1对象时,由于一级缓存中没有数据,所以会发送SQL语句,查询数据库中的数据
		Book b1=(Book) session.get(Book.class, 1);
		System.out.println(b1);
		Book b2=(Book) session.get(Book.class, 1);
		System.out.println(b2);
		//4.提交事务
		session.getTransaction().commit();
		//5.关闭资源
		session.close();
	}
	
	public void test3(){
		//1.得到session
		Session session=HibernateUtils.getSession();
		//2.开启事务
		session.beginTransaction();
		//3.操作
		Book book=new Book();
		book.setName("精通Hibernate");
		book.setPrice(65d);
		session.save(book);
		book.setName("精通Struts");
		//4.提交事务
		session.getTransaction().commit();
		//5.关闭资源
		session.close();
	}
	
	public void test4(){
		//1.获得session
		Session session=HibernateUtils.getSession();
		//2.开启事务
		session.beginTransaction();
		//3.操作
		Book book=(Book) session.get(Book.class, 2);
		book.setName("Java Web");
		//4.刷出
		session.flush();
		//5.提交事务
		session.getTransaction().commit();
		//6.关闭资源
		session.close();
	}
	
	public void test5(){
		//1.获得session
		Session session=HibernateUtils.getSession();
		//2.开启事务
		session.beginTransaction();
		//3.操作
		Book book=(Book) session.get(Book.class, 2);
		book.setName("Java基础");
		//4.清除缓存
		session.clear();
		//5.提交事务
		session.getTransaction().commit();
		//6.关闭资源
		session.close();
	}
	
	@Test
	public void test6(){
		//1.获得session
		Session session=HibernateUtils.getSession();
		//2.开启事务
		session.beginTransaction();
		//3.操作
		Book book=(Book) session.get(Book.class, 2);
		book.setName("精通Struts");
		//4.刷新
		session.refresh(book);
		System.out.println(book);
		//5.提交事务
		session.getTransaction().commit();
		//6.关闭资源
		session.close();
	}
}
