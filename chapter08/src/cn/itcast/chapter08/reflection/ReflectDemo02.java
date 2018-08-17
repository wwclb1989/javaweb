package cn.itcast.chapter08.reflection;

import java.lang.reflect.Constructor;

class Person1 {
	private String name;
	private int age;
	
	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class ReflectDemo02 {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.chapter08.reflection.Person1");
		Constructor cons[] = clazz.getConstructors();
		Person1 p = (Person1) cons[0].newInstance("李芳", 30);
		System.out.println(p);
	}

}
