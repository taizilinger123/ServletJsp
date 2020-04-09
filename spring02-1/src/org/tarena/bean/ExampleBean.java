package org.tarena.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//扫描ExampleBean组件，默认id=exampleBean
@Scope("singleton")//等价于<bean scope="">
public class ExampleBean {
	
	@PostConstruct//等价于<bean init-method="">
	public void init() {
		System.out.println("初始化逻辑");
	}
	
	@PreDestroy//等价于<bean destroy-method="">
	public void destroy(){
		System.out.println("释放资源");//需要2个条件:1.@Scope("singleton")singleton单例，2.AbstractApplicationContext，调用ac.close()方法
	}

	public void execute(){
		System.out.println("执行execute处理方法");
	}
}
