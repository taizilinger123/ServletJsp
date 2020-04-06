package org.tarena.bean;

public class Computer {
  
	private String cpu;
	private String hdd;
	private String mainbord;
	//œ‘ æ≈‰÷√–≈œ¢
	public void show(){
		System.out.println("cpu:"+cpu);
		System.out.println("hdd:"+hdd);
		System.out.println("mainbord:"+mainbord);
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public String getMainbord() {
		return mainbord;
	}
	public void setMainbord(String mainbord) {
		this.mainbord = mainbord;
	}
	

}
