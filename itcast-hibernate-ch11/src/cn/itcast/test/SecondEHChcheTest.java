package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.util.HibernateUtil;

public class SecondEHChcheTest {

	@Test
	public void testCache(){
		//开启第一个事务
		Session session1=HibernateUtil.getSession();
		Transaction tx1=session1.beginTransaction();
		//获取user1和user2对象
		User user1=(User) session1.get(User.class, 1);
		User user2=(User) session1.get(User.class, 1);
		System.out.println(user1==user2);		//第一次输出
		tx1.commit();							//提交事务1
		session1.close();						//session关闭,一级缓存被清理
		//开启第二个事务
		Session session2=HibernateUtil.getSession();
		Transaction tx2=session2.beginTransaction();
		//获取user3和user4对象
		User user3=(User) session2.get(User.class, 1);
		System.out.println(user1==user3);		//第二次输出
		User user4=(User) session2.get(User.class, 1);
		System.out.println(user3==user4);		//第三次输出
		tx2.commit();							//提交事务2
		session2.close();						//session2关闭
	}
}
