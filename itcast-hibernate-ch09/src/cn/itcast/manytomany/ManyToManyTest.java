package cn.itcast.manytomany;

import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

public class ManyToManyTest {

	public void test1(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		//1.创建两个学生
		Student s1=new Student();
		s1.setSname("张三");
		Student s2=new Student();
		s2.setSname("李四");
		//2.创建两个科目
		Course c1=new Course();
		c1.setCname("JAVA");
		Course c2=new Course();
		c2.setCname("PHP");
		//3.建立关联关系
		//学生关联科目
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		//科目关联学生
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c2.getStudents().add(s1);
		c2.getStudents().add(s2);
		//4.存储
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		//5.提交事务,关闭Session
		session.getTransaction().commit();
		session.close();
	}
	
	public void test2(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		Course course=new Course();
		course.setCname("PHP");
		
		Student student=new Student();
		student.setSname("王五");
		
		student.getCourses().add(course);
		
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void test3(){
		Session session=HibernateUtils.getSession();
		session.beginTransaction();
		
		Student student=(Student) session.get(Student.class, 4);
		session.delete(student);
		session.getTransaction().commit();
		session.close();
	}
	
}
