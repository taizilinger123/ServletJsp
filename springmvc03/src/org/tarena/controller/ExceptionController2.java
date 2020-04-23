package org.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController2 {
	
   @RequestMapping("/exception1.do")
   public String ex1(){
		   String s = null;
		   s.length();
		   return "ok";
   }
}
