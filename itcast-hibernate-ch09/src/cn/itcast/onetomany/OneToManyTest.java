package cn.itcast.onetomany;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

public class OneToManyTest {

	public void test1(){
		Session session=HibernateUtils.getSession();
		//1.创建一个客户
		session.beginTransaction();
		Customer c=new Customer();
		c.setName("张三");
		//2.创建两个订单
		Order o1=new Order();
		o1.setAddress("北京");
		o1.setPrice(10000d);
		Order o2=new Order();
		o2.setAddress("广州");
		o2.setPrice(5000d);
		//3.描述关系--订单属于某个客户
		o1.setCustomer(c);
		o2.setCustomer(c);
		//4.描述关系--客户有多个订单
		c.getOrders().add(o1);
		c.getOrders().add(o2);
		//5.先存客户再存订单
		session.save(c);
		session.save(o1);
		session.save(o2);
		session.getTransaction().commit();
		session.close();
	}
	
	public void test2(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		//1.客户
		Customer customer=new Customer();
		customer.setName("刘备");
		//2.订单
		Order order=new Order();
		order.setAddress("上海");
		order.setPrice(2000d);
		//3.客户关联订单
		customer.getOrders().add(order);
		//4.仅保存客户
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}
	
	public void test3(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		Customer c=(Customer) session.get(Customer.class, 8);
		
		session.delete(c);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	@Test
	public void test5(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		Customer customer=(Customer) session.get(Customer.class, 9);
		
		Order order=(Order) session.get(Order.class, 5);
		
		customer.getOrders().remove(order);
		
		session.getTransaction().commit();
		
		session.close();
	}
}
