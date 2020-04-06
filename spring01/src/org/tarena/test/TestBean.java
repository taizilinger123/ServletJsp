package org.tarena.test;

import java.util.Calendar;
import java.util.Date;
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
	  Calendar c2 = ac.getBean("c2", Calendar.class);
	  //ʹ��
	  System.out.println("c1="+c1);  
	  System.out.println("c2="+c2);  
//	  Date date = c2.getTime();
	  Date date = ac.getBean("date",Date.class);
	  System.out.println("date="+date);
	  
   }
}
