package org.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.Phone;

public class TestPhone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Phone phone = ac.getBean("p2",Phone.class);
        phone.show();
	}
}
