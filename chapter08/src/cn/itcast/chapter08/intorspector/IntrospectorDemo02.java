package cn.itcast.chapter08.intorspector;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import cn.itcast.chapter08.javabean.Person;

/**
 * 修改JavaBean的属性
 * @author wl
 *
 */
public class IntrospectorDemo02 {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		//使用属性描述器获取Person类name属性的描述信息
		PropertyDescriptor pd = new PropertyDescriptor("name", p.getClass());
		//获取name属性对应的setter方法
		Method methodName = pd.getWriteMethod();
		//调用setter方法，并设置name属性值
		methodName.invoke(p, "小明");
		String val = "20";
		
		pd = new PropertyDescriptor("age", p.getClass());
		Method methodAge = pd.getWriteMethod();
		//获取属性的java数据类型
		Class clazz = pd.getPropertyType();
		//根据类型来判断需要为setter方法传入什么类型的实参
		if (clazz.equals(int.class)) {
			methodAge.invoke(p, Integer.valueOf(val));
		} else {
			methodAge.invoke(p, val);
		}
		
		System.out.println(p);
	}
}
