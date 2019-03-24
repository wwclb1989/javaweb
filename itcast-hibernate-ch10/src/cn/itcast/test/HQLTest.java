package cn.itcast.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.domain.Customer;

public class HQLTest {

	/**
	 * 指定别名
	 */
	public void aliasTest(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		//得到一个Session
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		//编写HQL
		String hql="from Customer as c where c.name='王五'";
		//创建Query对象
		Query query=session.createQuery(hql);
		//执行查询,获得结果
		List<Customer> cs=query.list();
		//遍历查询结果
		for(Customer c:cs){
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void portionQueryTest(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="select c.name,c.age from Customer as c";
		
		Query query=session.createQuery(hql);
		
		List<Object[]>list=query.list();
		Iterator iter=list.iterator();
		
		while(iter.hasNext()){
			Object[] obj=(Object[])iter.next();
			System.out.println(obj[0]+" "+obj[1]);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void dynamicQueryTest(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="select new Customer(c.name,c.age) from Customer as c";
		
		Query query=session.createQuery(hql);
		
		List<Customer> cs=query.list();
		for(Customer c:cs){
			System.out.println(c.getName()+" "+c.getAge());
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void paramQueryTest1(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		String hql="from Customer where name like ?";
		Query query=session.createQuery(hql);
		query.setString(0, "王%");
		List<Customer> cs=query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void paramQueryTest2(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="from Customer where id=:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", 1);
		List<Customer> cs=query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void queryPageTest(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		String hql="from Customer";
		Query query=session.createQuery(hql);
		query.setFirstResult(2);		//从第3条开始查询
		query.setMaxResults(3);			//查询3条数据
		List<Customer> cs=query.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
}
