
public class Person {
	private String name;
	private int age;
	private long phone;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return this.phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return "Name: " + name + " - Age: " + age + " - Number: " + phone;
	}
}
