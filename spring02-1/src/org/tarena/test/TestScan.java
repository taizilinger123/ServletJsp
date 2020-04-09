package org.tarena.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tarena.bean.ExampleBean;
import org.tarena.bean.ExampleBean1;

public class TestScan {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  String conf = "applicationContext.xml";
		  AbstractApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		  ExampleBean  bean1 = ac.getBean("exampleBean",ExampleBean.class);
		  ExampleBean  bean = ac.getBean("exampleBean",ExampleBean.class);
		  System.out.println(bean1+"="+bean);
          bean1.execute();
          ExampleBean1  bean2 = ac.getBean("exam1",ExampleBean1.class);
          System.out.println(bean2);
          ac.close();//释放容器对象资源，触发单例对象的destroy-method
	}
}
