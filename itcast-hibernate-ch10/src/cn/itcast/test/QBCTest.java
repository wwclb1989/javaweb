package cn.itcast.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;

public class QBCTest {

	public void qbcTest1(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		//创建Criteria对象
		Criteria criteria=session.createCriteria(Customer.class);
		//设定查询条件
		Criterion criterion=Restrictions.or(Restrictions.eq("id", 1), Restrictions.eq("name", "王五"));
		//添加查询条件
		criteria.add(criterion);
		//执行查询,返回查询结果
		List<Customer> cs=criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void qbcTest2(){
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		List<Customer> cs=criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
}
