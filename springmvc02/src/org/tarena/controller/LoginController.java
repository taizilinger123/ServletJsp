package org.tarena.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    //�����¼ҳ��
	@RequestMapping("/tologin.do")
	public String toLogin(){
		return "login";//������ͼ����
	}
	//��¼��ť����
	@RequestMapping("/login.do")
	public String checkLogin(HttpServletRequest request){
		//��ȡ������Ϣ
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if("root".equals(name) && "1234".equals(password)){
			return "ok";//��ȷ����ok.jsp
		}else{
			return "login";//�������login.jsp
		}
	}
}
