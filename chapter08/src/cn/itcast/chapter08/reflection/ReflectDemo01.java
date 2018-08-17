package cn.itcast.chapter08.reflection;

class Person {
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
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class ReflectDemo01 {

	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("cn.itcast.chapter08.reflection.Person");
		Person p = (Person) clazz.newInstance();
		p.setName("李芳");
		p.setAge(18);
		System.out.println(p.toString());
	}
}
