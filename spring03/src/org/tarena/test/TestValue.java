package org.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.MyDataSource;

public class TestValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   String conf = "applicationContext.xml";
	   ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	   MyDataSource ds = ac.getBean("ds",MyDataSource.class);
	   ds.getConnection();
	}
}
