package addHibernateFile;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private SessionFactory sessionFactory;
	
	public HibernateSessionFactory(){}
	
	public SessionFactory config(){
		try {
			Configuration config=new Configuration().configure("hibernate.cfg.xml");
			return config.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Session getSession(){
		sessionFactory=config();
		return sessionFactory.openSession();
	}
	
	
}
