package cn.itcast.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 工具类,用来获取Session信息
 * @author ★天命之子★
 *
 */
public class HibernateUtils {

	private static final Configuration config;
	private static final SessionFactory factory;
	static{
		config=new Configuration().configure();
		factory=config.buildSessionFactory();
	}
	
	public static Session getSession(){
		return factory.openSession();
	}
}
