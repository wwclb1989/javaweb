package iocexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person=null;
		person=(Person)ac.getBean("中国人");
		person.eat();
		person.drink();
		person=(Person)ac.getBean("美国人");
		person.eat();
		person.drink();
	}

}
