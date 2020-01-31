package entity;
/**
 * 实体类
 *  用于封装从数据库查询出来的记录。
 *	
 */
public class Employee {
	private int id;
	@Override
	public String toString() {
		return id + " " 
		+ name + " " + salary
		+ " " + age;
	}
	private String name;
	private double salary;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
