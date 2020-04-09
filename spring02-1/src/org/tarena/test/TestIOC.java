package org.tarena.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.Computer;
import org.tarena.bean.Phone;
import org.tarena.bean.Student;

public class TestIOC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  String conf = "applicationContext.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		  Student s = ac.getBean("s",Student.class);
		  s.show();
//		  Computer c = ac.getBean("c",Computer.class);
//		  c.show();
//		  Phone p = ac.getBean("p",Phone.class);
//		  p.show();
	}
}
