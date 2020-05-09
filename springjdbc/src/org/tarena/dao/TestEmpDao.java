package org.tarena.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.entity.Emp;

public class TestEmpDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		EmpDao empDao = ac.getBean("empDao",EmpDao.class);
		//测试添加
//		Emp emp = new Emp();
//		emp.setName("spring");
//		emp.setSalary(10000.0);
//		emp.setAge(20);
//		empDao.save(emp);
		//测试删除
//		empDao.delete(21);
		//测试查询
		List<Emp> list = empDao.findAll();
		for(Emp emp : list){
			System.out.println(emp.getId()+""+emp.getName());
		}

	}
}
