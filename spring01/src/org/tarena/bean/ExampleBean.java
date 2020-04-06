package org.tarena.bean;

public class ExampleBean {
	public ExampleBean(){
		System.out.println("--创建ExampleBean--");
	}
	
	public void mydestory(){
		System.out.println("对象资源释放");
	}
	
	public void init(){
		System.out.println("解析其他配置文件");
	}
	
    public void execute(){
    	System.out.println("调用execute方法");
    }
}
