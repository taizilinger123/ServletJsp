package org.tarena.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyExceptionHandler implements HandlerExceptionResolver{
    
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object method, Exception e) {
		//将异常信息写入文件
		System.out.println("将异常信息写入文件:"+e);
		//跳转到错误页面
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		return mav;
	}
   
}
