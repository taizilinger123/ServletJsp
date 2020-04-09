package org.tarena.bean;

import org.springframework.stereotype.Component;

@Component("c")
public class Computer {
   public void show(){
	   System.out.println("显示计算机配置信息");
   }
}
