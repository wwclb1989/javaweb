package cn.itcast.chapter08.intorspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import cn.itcast.chapter08.javabean.Person;

public class IntrospectorDemo03 {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		p.setName("李芳");
		p.setAge(18);
		//使用属性描述器获取Person类name属性的描述信息
		PropertyDescriptor pd = new PropertyDescriptor("name", p.getClass());
		//获取name属性对应的getter方法
		Method methodName = pd.getReadMethod();
		//调用getter方法,并获取name属性值
		Object o = methodName.invoke(p);
		System.out.println("姓名:" + o);
		
		pd = new PropertyDescriptor("age", p.getClass());
		Method methodAge = pd.getReadMethod();
		o = methodAge.invoke(p);
		System.out.println("年龄:" + o);
	}

}
