package cn.itcast.chapter08.reflection;

import java.lang.reflect.Method;

class Person4 {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String sayHello(String name,int age) {
		return "大家好，我是" + name + ",今年" + age + "岁!";
	}
	
}

public class ReflectDemo04 {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.chapter08.reflection.Person4");
		Method md = clazz.getMethod("sayHello", String.class, int.class);
		String result = (String) md.invoke(clazz.newInstance(), "张三", 35);
		System.out.println(result);
	}

}
