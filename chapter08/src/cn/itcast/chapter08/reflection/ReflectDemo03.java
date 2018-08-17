package cn.itcast.chapter08.reflection;

import java.lang.reflect.Field;

class Person3 {
	private String name;
	private int age;
	@Override
	public String toString() {
		return "Person3 [name=" + name + ", age=" + age + "]";
	}
	
}

public class ReflectDemo03 {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.chapter08.reflection.Person3");
		Object p = clazz.newInstance();
		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(p, "李四");
		Field ageField = clazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(p, 20);
		System.out.println(p);
	}

}
