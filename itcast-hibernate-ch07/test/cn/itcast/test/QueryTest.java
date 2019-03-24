package cn.itcast.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.domain.Customer;

public class QueryTest {

	@Test
	public void fidAll_hqlTest(){
		//加载hibernate.cfg.xml配置
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		//1.得到一个Session
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		//2.编写HQL,其中的Customer代表的是类
		String hql="from Customer";
		//3.调用session.createQuery创建查询对象
		Query query=session.createQuery(hql);
		//4.使用query.list()方法查询数据,并将数据放入一个list集合
		List<Customer> list=query.list();
		//循环输出集合中的数据
		for (Customer c : list) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
}
