package cn.itcast.chapter08.beanutils;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.chapter08.javabean.Person;

public class BeanUtilsDemo01 {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "Jack");
		BeanUtils.setProperty(p, "age", "10");
		String name = BeanUtils.getProperty(p, "name");
		String age = BeanUtils.getProperty(p, "age");
		System.out.println("我的名字是" + name + ",我今年" + age + "岁了!");
	}
}
