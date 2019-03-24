package loginRegisterDao;

import addHibernateFile.HibernateSessionFactory;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import PO.UserInfoPO;

/**
 * 数据库操作类
 * @author ★天命之子★
 *
 */
public class LoginRegisterInfo {

	private Session session;
	private Transaction transaction;
	private Query query;
	HibernateSessionFactory getSession;
	
	public String saveInfo(UserInfoPO info){
		String mess="error";
		getSession=new HibernateSessionFactory();
		session=getSession.getSession();
		try {
			transaction=session.beginTransaction();
			session.save(info);
			transaction.commit();
			mess="success";
			return mess;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return mess;
	}
	
	public List queryInfo(String type,Object value){
		getSession=new HibernateSessionFactory();
		session=getSession.getSession();
		
		try {
			String hqlsql="from UserInfoPO as u where u.username=?";
			query=session.createQuery(hqlsql);
			query.setParameter(0, value);
			List list=query.list();
			transaction=session.beginTransaction();
			transaction.commit();
			return list;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
