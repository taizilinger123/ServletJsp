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
		//�������
//		Emp emp = new Emp();
//		emp.setName("spring");
//		emp.setSalary(10000.0);
//		emp.setAge(20);
//		empDao.save(emp);
		//����ɾ��
//		empDao.delete(21);
		//���Բ�ѯ
		List<Emp> list = empDao.findAll();
		for(Emp emp : list){
			System.out.println(emp.getId()+""+emp.getName());
		}

	}
}
