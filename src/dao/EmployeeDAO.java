package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Employee;
/**
 * DAO类：
 *     封装了访问数据库的代码。
 * 
 *
 */
public class EmployeeDAO {
    public List<Employee>  findAll() throws Exception{
    	List<Employee> employees = new ArrayList<Employee>();
    	Connection conn = null;
    	PreparedStatement prep = null;
    	ResultSet rst = null;
    	try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement("SELECT * FROM emp");
			rst = prep.executeQuery();
			while(rst.next()){
				int id = rst.getInt("id");
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				int age = rst.getInt("age");
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setAge(age);
				employees.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(conn);
		}
    	return employees;
    }
    
    public void save(Employee e) throws Exception{
    	Connection conn = null;
    	PreparedStatement prep = null;
    	try {
			conn = DBUtil.getConnection();
			prep = conn.prepareStatement("INSERT INTO emp(name, salary, age) VALUES(?,?,?)");
		    prep.setString(1, e.getName());
		    prep.setDouble(2, e.getSalary());
		    prep.setInt(3, e.getAge());
		    prep.executeUpdate();
    	} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}finally{
			DBUtil.close(conn);
		}
    }
    
    public void delete(int id){
    	
    }
    
    public Employee findById(int id){
    	Employee e = null;
    	return e;
    }
    
    public void modify(Employee e){
    	
    }
    
    public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
//		List<Employee> employees = dao.findAll();
//		System.out.println(employees);
		Employee e = new Employee();
		e.setName("emp111");
		e.setSalary(2000);
		e.setAge(22);
		dao.save(e);
	}
}
