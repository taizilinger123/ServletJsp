package org.tarena.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("s")
public class Student {

	// 需要调用computer和phone对象
	@Resource//默认按名称,如果找不到c对象按类型
	private Computer c;//注入Computer对象

//	public void setC(Computer c) {
//		this.c = c;
//	}
	
	
//	private Phone p;//注入Phone对象
//	@Resource
//	public void setP(Phone p) {
//		this.p = p;
//	}
	
//	@Autowired//按类型
//	@Qualifier("p1")
	private Phone p;//注入Phone对象	
//	@Autowired//按类型
//	@Qualifier("p")//指定名称按p找
//	@Resource
//	@Resource(name="p")//指定名称按p找
    @Autowired//按类型
	public void setP(@Qualifier("p1") Phone pp) {
		this.p = pp;
	}

	public void show() {
		System.out.println("学生信息");
		c.show();
		p.show();
	}
}
