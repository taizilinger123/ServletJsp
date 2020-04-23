package org.tarena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller//É¨Ãèµ½Spring
public class HelloController {
	
   @RequestMapping("/hello.do")
   public ModelAndView execute(){
	   ModelAndView mav = new ModelAndView();
	   mav.setViewName("hello");
	   mav.getModel().put("msg", "×¢½â°æ");
	   return mav;
   }
}
