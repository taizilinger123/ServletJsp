package entity;
/**
 * ʵ����:
 *   ������������ݿ��ѯ����������
 * 
 *
 */
public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;
    
	@Override
	public String toString() {
		return id + "" + name + " " + salary+ " " + age;
	}
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
