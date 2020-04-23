package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tarena.entity.User;

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
		request.setCharacterEncoding("utf-8");
		//获取请求信息
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if("root".equals(name) && "1234".equals(password)){
			request.getSession().setAttribute("username", name);
			return "ok";//正确进入ok.jsp
		}else{
			return "login";//错误进入login.jsp
		}
	}
	
	//测试使用方法参数接收request信息
	@RequestMapping("/login1.do")
	public String checkLogin1(@RequestParam("username")String name,String password){
		System.out.println("--执行checkLogin1--");
		System.out.println("username:"+name);
		System.out.println("password:"+password);
		return "login";//回到登录页面
	}
	
	//测试用实体对象user接收请求参数
	@RequestMapping("/login2.do")
	public String checkLogin2(User user){
		System.out.println("--执行checkLogin2--");
		System.out.println("username:"+user.getUsername());
		System.out.println("password:"+user.getPassword());
		return "login";
	}
	
	@RequestMapping("/login3.do")
	public String checkLogin3(String username,String password,ModelMap model,HttpSession session){
		System.out.println("--执行checkLogin3--");
		System.out.println("username"+username);
		System.out.println("password"+password);
		if("root".equals(username) && "1234".equals(password)){
			model.put("user", username);
			session.setAttribute("username", username);
			return "ok";//ok.jsp使用${user}
		}else{
			model.put("msg", "用户名或密码错误");
			return "login";//login.jsp使用${msg}
		}
	}
}
