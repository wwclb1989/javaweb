package cn.itcast.chapter08.beanutils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.chapter08.javabean.Person;

public class BeanutilsDemo02 {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.chapter08.javabean.Person");
		Person p = (Person) clazz.newInstance();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "张三");
		map.put("age", 10);
		BeanUtils.populate(p, map);
		System.out.println(p);
	}
}
