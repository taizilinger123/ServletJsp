package org.tarena.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("s")
public class Student {

	// ��Ҫ����computer��phone����
	@Resource//Ĭ�ϰ�����,����Ҳ���c��������
	private Computer c;//ע��Computer����

//	public void setC(Computer c) {
//		this.c = c;
//	}
	
	
//	private Phone p;//ע��Phone����
//	@Resource
//	public void setP(Phone p) {
//		this.p = p;
//	}
	
//	@Autowired//������
//	@Qualifier("p1")
	private Phone p;//ע��Phone����	
//	@Autowired//������
//	@Qualifier("p")//ָ�����ư�p��
//	@Resource
//	@Resource(name="p")//ָ�����ư�p��
    @Autowired//������
	public void setP(@Qualifier("p1") Phone pp) {
		this.p = pp;
	}

	public void show() {
		System.out.println("ѧ����Ϣ");
		c.show();
		p.show();
	}
}
