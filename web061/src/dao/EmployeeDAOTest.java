package dao;

import java.util.List;

import org.junit.Test;

import entity.Employee;

public class EmployeeDAOTest {
	@Test
	public void testModify() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = dao.findById(3);
		e.setName("jdbc");
		dao.modify(e);
	}
	
	@Test
	public void testFindAll() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = 
			dao.findAll();
		System.out.println(employees);
	}
	
	@Test
	public void testSave() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setName("kkk");
		e.setSalary(1000);
		e.setAge(22);
		dao.save(e);
	}
	
	@Test
	public void testDelete() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		dao.delete(1);
	}
	
	@Test
	public void testFindById() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = dao.findById(3);
		System.out.println(e);
	}

}
