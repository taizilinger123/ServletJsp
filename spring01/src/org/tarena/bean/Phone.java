package org.tarena.bean;

public class Phone {
  
	private String cpu;
	private String ram;
	//������ע��ʹ��
	public Phone(String cpu,String ram){
		this.cpu = cpu;//this.cpu����private String cpu,=cpu����String cpu
		this.ram = ram;
	}
	
	public void show(){
		System.out.println("--�ֻ�����--");
		System.out.println("cpu:"+cpu);
		System.out.println("ram:"+ram);
	}
}
