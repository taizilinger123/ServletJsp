package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		// ���������ύ���û��������룬�ж�
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if("root".equals(name) && "1234".equals(password)){
			mav.setViewName("ok");//��ȷ
		}else{
		    mav.setViewName("login");//����	
		}
		return mav;
	}
   
}
