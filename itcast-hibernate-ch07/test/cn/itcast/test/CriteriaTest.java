package cn.itcast.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;

public class CriteriaTest {

	@Test
	public void qbcTest(){
		//加载hibernate.cfg.xml配置
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		//1.得到一个Session
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		//2.通过Session获得Criteria对象
		Criteria criteria=session.createCriteria(Customer.class);
		//3.使用Restrictions的eq方法设定查询条件为name="王五",
		//4.向Criteria对象中添加name="王五"的查询条件
		criteria.add(Restrictions.eq("name", "王五"));
		//5.执行Criteria的list()获得结果
		List<Customer> cs=criteria.list();
		for (Customer c : cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
}
