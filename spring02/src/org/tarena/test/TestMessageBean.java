package org.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.MessageBean;

public class TestMessageBean {
   public static void main(String[] args) {
		  String conf = "applicationContext.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		  MessageBean msg = ac.getBean("msg",MessageBean.class);
		  msg.show();
   }
}
