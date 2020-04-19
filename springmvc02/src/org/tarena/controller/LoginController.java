package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    //进入登录页面
	@RequestMapping("/tologin.do")
	public String toLogin(){
		return "login";//返回视图名称
	}
	//登录按钮处理
	@RequestMapping("/login.do")
	public String checkLogin(HttpServletRequest request){
		//获取请求信息
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if("root".equals(name) && "1234".equals(password)){
			return "ok";//正确进入ok.jsp
		}else{
			return "login";//错误进入login.jsp
		}
	}
}
