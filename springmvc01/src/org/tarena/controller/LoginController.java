package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class LoginController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		// 接收请求提交的用户名和密码，判断
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if("root".equals(name) && "1234".equals(password)){
			mav.setViewName("ok");//正确
		}else{
		    mav.setViewName("login");//错误	
		}
		return mav;
	}
   
}
