package org.tarena.bean;

import org.springframework.stereotype.Component;

@Component("p")
public class Phone {
   public void show(){
	   System.out.println("显示手机配置信息");
   }
}
