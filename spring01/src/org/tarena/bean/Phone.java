package org.tarena.bean;

public class Phone {
  
	private String cpu;
	private String ram;
	//构造器注入使用
	public Phone(String cpu,String ram){
		this.cpu = cpu;//this.cpu就是private String cpu,=cpu就是String cpu
		this.ram = ram;
	}
	
	public void show(){
		System.out.println("--手机配置--");
		System.out.println("cpu:"+cpu);
		System.out.println("ram:"+ram);
	}
}
