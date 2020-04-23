package org.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController1 {
	
   @RequestMapping("/exception1.do")
   public String ex1(){
	   try{
		   String s = null;
		   s.length();
		   return "ok";
	   }catch(Exception ex){
		   return "error";
	   }
   }
}
