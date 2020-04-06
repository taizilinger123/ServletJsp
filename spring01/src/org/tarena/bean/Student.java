package org.tarena.bean;

public class Student {
  
	private Computer c;
	private Phone p;
	
	public void show(){
		c.show();
		p.show();
	}
	
	public void setC(Computer c) {
		this.c = c;
	}

	public void setP(Phone p) {
		this.p = p;
	}
}
