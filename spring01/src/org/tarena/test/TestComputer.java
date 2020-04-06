package org.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.Computer;

public class TestComputer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Computer c = new Computer();
//		c.setCpu("i7");
//		c.setHdd("Ï£½Ý");
//      c.setMainbord("»ªË¶");
		String conf = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		Computer c = ac.getBean("p1",Computer.class);
        c.show();
	}
}
