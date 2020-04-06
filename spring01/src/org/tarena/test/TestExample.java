package org.tarena.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.ExampleBean;

public class TestExample {
   public static void main(String[] args) {
		  String conf = "applicationContext.xml";
		  AbstractApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		  ExampleBean e1 = ac.getBean("e1",ExampleBean.class);
		  e1.execute();
		  ExampleBean e2 = ac.getBean("e1",ExampleBean.class);
		  System.out.println(e1);
		  System.out.println(e2);
		  System.out.println(e1==e2);
		  ac.close();//释放spring容器对象，自动调用单例的destroy-method
   }
}
