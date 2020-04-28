package org.tarena.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
    //请求处理完毕，输出之前
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--afterCompletion--");
		
	}
    //controller之后
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--postHandle--");
		
	}
    //controller之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		System.out.println("--preHandle实现登录检查--");
		HttpSession session = request.getSession();
		//获取登录成功后放置的用户信息
		String name = (String)session.getAttribute("username");
		if(name != null){//登录过
			return true;//继续执行mvc后续流程
		}else{//未登录或登录失效
			response.sendRedirect("tologin.do");
			return false;//终止mvc后续流程
		}
		
	}
    
}
