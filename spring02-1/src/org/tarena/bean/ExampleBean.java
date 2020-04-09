package org.tarena.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//ɨ��ExampleBean�����Ĭ��id=exampleBean
@Scope("singleton")//�ȼ���<bean scope="">
public class ExampleBean {
	
	@PostConstruct//�ȼ���<bean init-method="">
	public void init() {
		System.out.println("��ʼ���߼�");
	}
	
	@PreDestroy//�ȼ���<bean destroy-method="">
	public void destroy(){
		System.out.println("�ͷ���Դ");//��Ҫ2������:1.@Scope("singleton")singleton������2.AbstractApplicationContext������ac.close()����
	}

	public void execute(){
		System.out.println("ִ��execute������");
	}
}
