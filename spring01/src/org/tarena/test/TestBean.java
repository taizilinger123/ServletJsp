package org.tarena.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {
   public static void main(String[] args) {
//	  Calendar c = new GregorianCalendar();
//	  Calendar c1 = Calendar.getInstance();
	  //����Spring��������
	  String conf = "applicationContext.xml";
	  ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	  //��Spring������ȡc1
	  Calendar c1 = ac.getBean("c1", Calendar.class);
	  //ʹ��
	  System.out.println(c1);  
   }
}
